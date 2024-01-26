package com.example.studirajmozajednojava

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@Composable
fun fakultetUnit(
    fakultet: Fakulet,
    packageContext: Context = LocalContext.current,
    inFavorites: Boolean,
    save: () -> Unit,
    unsave: () -> Unit
) {
    var inFavoritesLocal by remember {
        mutableStateOf(inFavorites)
    }
    val index = Fakulteti.fakultetiList.indexOf(fakultet)
    ElevatedCard (
        modifier = Modifier
            .clickable {
                val next_activity = Intent(packageContext,  PopupInfoActivityKotlin::class.java)
                next_activity.putExtra("fakultet_index", index)
                ContextCompat.startActivity(packageContext, next_activity, Bundle())
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ){
        Row(modifier = Modifier
            .height(120.dp)){
            Image(
                painter = painterResource(id = fakultet.picId),
                contentDescription = fakultet.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        modifier = Modifier
                            .padding(10.dp, 10.dp, 10.dp, 60.dp)
                            .fillMaxSize(),
                        text = fakultet.name,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        maxLines = 2
                    )
                    var buttonText by rememberSaveable {
                        mutableStateOf("Spasi")
                    }
                    if (inFavorites) {
                        buttonText = "Ukloni iz spašenih"
                    }
                    SmallFloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(30.dp, 13.dp),
                        onClick = {
                            inFavoritesLocal = !inFavoritesLocal
                            if (inFavoritesLocal) save()
                            else unsave()
                        },
                        elevation = FloatingActionButtonDefaults.elevation(0.dp)
                    ) {
                        if (inFavoritesLocal) {
                            Icon(imageVector = Icons.Sharp.Favorite, contentDescription = "Favorites Icon")
                        } else Icon(imageVector = Icons.Sharp.FavoriteBorder, contentDescription = "Favorites Icon")

                    }
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp, 75.dp, 80.dp, 10.dp),
                        text = fakultet.city,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        maxLines = 2
                    )
                }
            }
        }
    }
}
@Composable
fun fakultetUnitBig(
    fakultet: Fakulet,
    packageContext: Context = LocalContext.current,
    inFavorites: Boolean,
    save: () -> Unit,
    unsave: () -> Unit
) {
    val index = Fakulteti.fakultetiList.indexOf(fakultet)
    ElevatedCard (
        modifier = Modifier
            .clickable {
                val next_activity = Intent(packageContext,  PopupInfoActivityKotlin::class.java)
                next_activity.putExtra("fakultet_index", index)
                ContextCompat.startActivity(packageContext, next_activity, Bundle())
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ){
        Row(modifier = Modifier
            .height(170.dp)){
            Image(
                painter = painterResource(id = fakultet.picId),
                contentDescription = fakultet.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(170.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        modifier = Modifier
                            .padding(10.dp, 25.dp, 10.dp, 60.dp)
                            .fillMaxSize(),
                        text = fakultet.name,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        maxLines = 2
                    )
                    var inFavoritesLocal by remember {
                        mutableStateOf(inFavorites)
                    }
                    SmallFloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(30.dp, 30.dp),
                        onClick = {
                            inFavoritesLocal = !inFavoritesLocal
                            if (inFavoritesLocal) save()
                            else unsave()
                        },
                        elevation = FloatingActionButtonDefaults.elevation(0.dp)
                    ) {
                        if (inFavoritesLocal) {
                            Icon(imageVector = Icons.Sharp.Favorite, contentDescription = "Favorites Icon")
                        } else Icon(imageVector = Icons.Sharp.FavoriteBorder, contentDescription = "Favorites Icon")

                    }
                    Text(
                        modifier = Modifier
                            .padding(10.dp, 105.dp, 75.dp, 10.dp)
                            .fillMaxSize(),
                        text = fakultet.city,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        maxLines = 2
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun fakultetUnitPreview() {
    fakultetUnit(
        Fakulteti.fakultetiList[1],
        inFavorites = false,
        save = { },
        unsave = { }
    )
}

@Preview
@Composable
fun fakultetUnitBigPreview() {
    fakultetUnitBig(
        Fakulteti.fakultetiList[1],
        inFavorites = false,
        save = { },
        unsave = { }
    )
}