package com.example.studirajmozajednojava

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@Composable
fun SetupNavHostEvaluationProcess(
    packageContext: Context,
    navController: NavHostController,
    lifecycle: LifecycleCoroutineScope,
    dataStore: DataStore<Preferences>
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Evaluation1.route
    ){
        composable(
            route = Screen.Evaluation1.route
        ) {
            BackHandler(true) {

            }
            Evaluation1(navController)
        }
        composable(
            route = Screen.Evaluation2.route
        ) {
            Evaluation2 {
                lifecycle.launch {
                    saveUserData("smijer", it, dataStore)
                    navController.navigate(Screen.Evaluation3.route)
                }
            }
        }
        composable(
            route = Screen.Evaluation3.route
        ) {
            Evaluation3 {
                lifecycle.launch {
                    saveUserData("prosjek", it, dataStore)
                    navController.navigate(Screen.Evaluation4.route)
                }
            }
        }
        composable(
            route = Screen.Evaluation4.route
        ) {
            Evaluation4 {
                lifecycle.launch {
                    saveUserData("zavrsenihRazreda", it, dataStore)
                    startActivity(packageContext, Intent(packageContext, MainMeatActivity::class.java), Bundle())
                }
            }
        }
    }
}