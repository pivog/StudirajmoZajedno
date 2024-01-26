package com.example.studirajmozajednojava

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class StartActivity : ComponentActivity() {

    lateinit var dataStore: DataStore<Preferences>
    lateinit var context: Context

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3NavigationDrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    context = LocalContext.current
                    dataStore = accessUserData(LocalContext.current)
                    var firstTime: Boolean
                    lifecycleScope.launch {
                        firstTime = (read("zavrsenihRazreda", dataStore) == "")
                        if (firstTime){
                            val next_activity = Intent(context,  EvaluationActivity::class.java)
                            ContextCompat.startActivity(context, next_activity, Bundle())
                            return@launch
                        }
                        val next_activity = Intent(context,  MainMeatActivity::class.java)
                        ContextCompat.startActivity(context, next_activity, Bundle())
                    }
                }
            }
        }
    }
}

fun getFakultetiFiltered(dataStore: DataStore<Preferences>) {

}