package com.example.studirajmozajednojava

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme

class TestActivityKotlin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var dataStore: DataStore<Preferences> = createDataStore("userData")
        super.onCreate(savedInstanceState)
        setContent {
            M3NavigationDrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    M3NavigationDrawerTheme {
        Greeting("Android")
    }
}