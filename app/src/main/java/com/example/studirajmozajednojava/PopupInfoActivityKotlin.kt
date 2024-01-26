package com.example.studirajmozajednojava

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PopupInfoActivityKotlin : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var context = LocalContext.current
            M3NavigationDrawerTheme {
                PopupInfoScreen(fakultet = Fakulteti.fakultetiList[intent.getIntExtra("fakultet_index", 1)])
            }
        }
    }
}