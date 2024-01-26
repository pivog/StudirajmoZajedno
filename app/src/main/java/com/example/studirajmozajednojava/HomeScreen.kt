package com.example.studirajmozajednojava

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme

@Composable
fun HomeScreen(
    onClickMore: () -> Unit = { },
    packageContext: Context = LocalContext.current,
    save: (Fakulet) -> Unit,
    unsave: (Fakulet) -> Unit,
    isInFavorites: (Fakulet) -> Boolean,
    userTailoredList: List<Fakulet>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Fakulteti.fakultetiList.forEachIndexed {
//                _, fakulet ->
//            item {
//                Box(
//                    modifier = Modifier
//                        .padding(10.dp, 0.dp)
//                )
//                fakultetUnit(fakultet = fakulet)
//            }
//            item {
//                Surface{
//                    Spacer(modifier = Modifier.height(15.dp))
//                }
//            }
//        }
        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
        item {
            Text(
                text = "Naša najbolja preporuka",
                fontSize = 20.sp
            )
        }
        item { Spacer(modifier = Modifier.height(30.dp)) }
        item {
            fakultetUnitBig(
                fakultet = userTailoredList[0],
                save = {
                    save(userTailoredList[0])
                },
                unsave = {
                    unsave(userTailoredList[0])
                },
                inFavorites = isInFavorites(userTailoredList[0])
            )
        }
        item { Spacer(modifier = Modifier.height(45.dp)) }
        item {
            if (userTailoredList.size == 1) Text(text = "Ovo je jedini fakultet koji nudi smijer koji ste odabrali")
            else Text(text = "Ostali fakulteti pogodni za tebe")
        }
        if(userTailoredList.size > 1) {
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                fakultetUnit(
                    fakultet = userTailoredList[1],
                    save = {
                        save(userTailoredList[1])
                    },
                    unsave = {
                        unsave(userTailoredList[1])
                    },
                    inFavorites = isInFavorites(userTailoredList[1])
                )
            }
        }
        if(userTailoredList.size > 2) {
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                fakultetUnit(
                    fakultet = userTailoredList[2],
                    save = {
                        save(userTailoredList[2])
                    },
                    unsave = {
                        unsave(userTailoredList[2])
                    },
                    inFavorites = isInFavorites(userTailoredList[2])
                )
            }
        }
        if(userTailoredList.size > 3) {
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                fakultetUnit(
                    fakultet = userTailoredList[3],
                    save = {
                        save(userTailoredList[3])
                    },
                    unsave = {
                        unsave(userTailoredList[3])
                    },
                    inFavorites = isInFavorites(userTailoredList[3])
                )
            }
        }
        item { Spacer(
            modifier = Modifier
                .height(30.dp)
        ) }
        if (userTailoredList.size > 1) {
            item {
                ElevatedButton(
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        onClickMore()
                    }
                ) {
                    Text(text = "Učitaj više")
                }
            }
            item { Spacer(modifier = Modifier.height(30.dp)) }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    M3NavigationDrawerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(
                save = {

                },
                unsave = {

                },
                isInFavorites = { return@HomeScreen false },
                userTailoredList = Fakulteti.fakultetiList.toList()
            )
        }
    }
}