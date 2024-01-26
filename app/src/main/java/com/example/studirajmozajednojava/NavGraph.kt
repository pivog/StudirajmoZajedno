package com.example.studirajmozajednojava

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SetupNavHost(
    packageContext: Context,
    navController: NavHostController,
    lifecycle: LifecycleCoroutineScope,
    save: (Fakulet) -> Unit,
    unsave: (Fakulet) -> Unit,
    getFromQuery: (String, MutableState<MutableMap<String, Boolean>>) -> Unit,
    activeFakultetiList: MutableState<MutableList<Fakulet>>,
    isInFavorites: (Fakulet, MutableList<Int>) -> Boolean,
    getUserTailoredList: () -> List<Fakulet>,
    SelectedNavItemIndex: MutableIntState
) {
    var getProsjekDef:Deferred<Double> = lifecycle.async {
        read("prosjek", accessUserData(packageContext)).toDouble()
    }
    var getSmijerDef:Deferred<String> = lifecycle.async {
        read("smijer", accessUserData(packageContext))
    }
    var getZavrsenihRazredaDef:Deferred<Int> = lifecycle.async {
        return@async read("zavrsenihRazreda", accessUserData(packageContext)).toInt()
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Favorites.route
        ) {
            FavoritesScreen(
                getFavorites(accessUserData(packageContext)),
                save = {
                    save(it)
                },
                unsave = {
                    unsave(it)
                         },
                isInFavorites = {
                    isInFavorites(it, getFavorites(accessUserData(packageContext)))
                }
            )
        }
        composable(
            route = Screen.Search.route
        ) {
            val checkedCities = remember {
                mutableStateOf(mutableMapOf<String, Boolean>())
            }
            getCities().forEach {
                checkedCities.value[it] = true            }
            FilterDrawer(filters = checkedCities, activeFakultetiList = activeFakultetiList, save = save, unsave = unsave, getFromQuery = { getFromQuery(it, checkedCities)})
        }
        composable(
            route = Screen.Home.route
        ) {
            BackHandler(true) {

            }
            HomeScreen(
                onClickMore = {
                    navController.navigate(Screen.PrikazList.route)
                },
                save = {
                    save(it)
                },
                unsave = { unsave(it) },
                isInFavorites = { isInFavorites(it, getFavorites(accessUserData(packageContext)))},
                userTailoredList = getUserTailoredList()
            )
        }
        composable(
            route = Screen.PrikazList.route
        ) {
            PrikazFakulteta(
                save = {
                    save(it)
                },
                unsave = { unsave(it) },
                isInFavorites = { isInFavorites(it, getFavorites(accessUserData(packageContext)))},
                userTailoredList = getUserTailoredList()
            )
        }
        composable(
            route = Screen.Settings.route
        ) {
            OptionsScreen {
                lifecycle.launch {
                    saveUserData("smijer", "", accessUserData(packageContext))
                    saveUserData("zavrsenihRazreda", "", accessUserData(packageContext))
                    saveUserData("prosjek", "", accessUserData(packageContext))
                    saveUserData("spaseniIndicies", "", accessUserData(packageContext))
                    (packageContext as Activity).finishAffinity()
                }
            }
        }
        composable(
            route = Screen.PopupInfo.route
        ) { navBackStackEntry ->
            /* Extracting the id from the route */
            val uId = navBackStackEntry.arguments?.getInt("fakultet")
            /* We check if it's not null */
            uId?.let { id->
                PopupInfoScreen(fakultet = Fakulteti.fakultetiList[id])
            }
        }
        composable(
            route = Screen.ProfileSettings.route
        ) {
            ProfileSettingsScreen(
                saveSmijer = {
                    runBlocking {
                        saveUserData("smijer", it, accessUserData(packageContext))
                        navController.navigate(Screen.Home.route)
                    }
                },
                saveRazred = {
                    runBlocking {
                        saveUserData("zavrsenihRazreda", it.toString(), accessUserData(packageContext))
                    }
                },
                saveProsjek = {
                    runBlocking {
                        saveUserData("prosjek", it.toString(), accessUserData(packageContext))
                    }
                },
                smijerCurrent = runBlocking { getSmijerDef.await() },
                razredCurrent = runBlocking { getZavrsenihRazredaDef.await() },
                prosjekCurrent = runBlocking {
                    SelectedNavItemIndex.intValue = 0
                    return@runBlocking getProsjekDef.await()
                }
            )
        }
    }
}