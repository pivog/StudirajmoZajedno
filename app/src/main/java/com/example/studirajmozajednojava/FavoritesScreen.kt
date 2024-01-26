package com.example.studirajmozajednojava

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FavoritesScreen(
    favoritesIndicies: MutableList<Int>,
    save: (Fakulet) -> Unit,
    unsave: (Fakulet) -> Unit,
    isInFavorites: (Fakulet) -> Boolean
) {
    val favoritesIndiciesLast = favoritesIndicies
    LazyColumn(
        modifier =
        Modifier.fillMaxSize()
    ) {
        favoritesIndiciesLast.forEachIndexed {
                _, index ->
            Log.println(Log.DEBUG, "FavoritesScreen", index.toString())
            item {
                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                )
                fakultetUnit(
                    fakultet = Fakulteti.fakultetiList[index],
                    save = {
                        save(Fakulteti.fakultetiList[index])
                    },
                    unsave = {
                        unsave(Fakulteti.fakultetiList[index])
                    },
                    inFavorites = isInFavorites(Fakulteti.fakultetiList[index])
                )
            }
            item {
                Surface{
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }

}


@Preview
@Composable
fun FavoritesScreenPreview() {
    M3NavigationDrawerTheme {
        FavoritesScreen(
            favoritesIndicies = MutableList<Int>(1, { 1 }),
            save = { },
            unsave = { },
            isInFavorites = { return@FavoritesScreen false }
        )
    }
}