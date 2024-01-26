package com.example.studirajmozajednojava

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val route: String
)

class MainMeatActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val activeFakultetiList = remember {
                mutableStateOf(Fakulteti.fakultetiList.toMutableList())
            }
            fun getSmijerChosen(): String {
                var smijer: String
                runBlocking {
                    smijer = read("smijer", accessUserData(context))
                }
                return smijer
            }
            fun getProsjek(): Double {
                var prosjek: Double
                runBlocking {
                    prosjek = read("prosjek", accessUserData(context)).toDouble()
                }
                return prosjek
            }
            var selectedItemIndex = remember {
                mutableIntStateOf(0)
            }
            M3NavigationDrawerTheme {
                navController = rememberNavController()
                NavigationDrawer(navController, selectedItemIndex = selectedItemIndex) {
                    SetupNavHost(
                        LocalContext.current,
                        navController,
                        lifecycleScope,
                        save = {
                            lifecycleScope.launch {
                                val oldIndicies = read("spaseniIndicies", accessUserData(context))
                                saveUserData("spaseniIndicies", "$oldIndicies ${Fakulteti.fakultetiList.indexOf(it)}".trim(), accessUserData(context))
                            }
                        },
                        unsave = {
                            runBlocking {
                                var fakultet = it
                                val oldIndicies = read("spaseniIndicies", accessUserData(context))
                                val oldIndiciesList = oldIndicies.split(" ")
                                val newIndicies = oldIndiciesList.toMutableList()
                                newIndicies.remove(Fakulteti.fakultetiList.indexOf(it).toString())
                                saveUserData("spaseniIndicies", newIndicies.joinToString(separator = " "), accessUserData(context))
                            }
                        },
                        isInFavorites = {
                            fakultet, indicies ->
                            val isIt = Fakulteti.fakultetiList.indexOfFirst { it.name == fakultet.name} in indicies
                            return@SetupNavHost isIt
                        },
                        getFromQuery = { newText, cities ->
                            lifecycleScope.launch {
                                var fakultetiListInWorking = Fakulteti.fakultetiList.toMutableList()
                                fakultetiListInWorking = fakultetiListInWorking.filter {
                                    it.doesMatchSearchQuery(newText)
                                }.toMutableList().filter {
                                    cities.value[it.city] == true
                                }.toMutableList()
                                fakultetiListInWorking = fakultetiListInWorking.sortedWith(compareBy { it.name }).toMutableList()
                                activeFakultetiList.value = fakultetiListInWorking
                                Log.println(Log.DEBUG, "searchScreen", activeFakultetiList.value.size.toString())
                            }
                        },
                        activeFakultetiList = activeFakultetiList,
                        getUserTailoredList = {
                            getFilteredAndSorted(getSmijerChosen(), getProsjek())
                        },
                        SelectedNavItemIndex = selectedItemIndex
                    )
                }
            }
        }
    }
}