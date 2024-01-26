package com.example.studirajmozajednojava

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import java.nio.file.WatchEvent

@Composable
fun PopupInfoScreen(fakultet: Fakulet) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                item{
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = fakultet.name,
                        fontSize = 27.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 33.sp,
                        modifier = Modifier.padding(5.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = painterResource(id = fakultet.picId),
                        contentDescription = "image of campus probably?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = fakultet.phoneNum,
                        fontSize = 20.sp
                    )
                    if (fakultet.email != "placeholder@gmail.com"){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = fakultet.email,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "${fakultet.addr}, ${fakultet.city}",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
                item {
                    Text(
                        modifier = Modifier.padding(20.dp, 5.dp),
                        text = fakultet.desc
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(20.dp, 5.dp, 0.dp, 0.dp),
                        text = "Ponuđeni Studiji:"
                    )
                }
                for (studij in fakultet.smjerovi) {
                    if (studij.trim() != "") {
                        item {
                            Text(
                                modifier = Modifier.padding(20.dp, 5.dp),
                                text = "• $studij"
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun PopupInfoScreenPreview() {
    M3NavigationDrawerTheme {
        PopupInfoScreen(Fakulteti.fakultetiList[5])
    }
}