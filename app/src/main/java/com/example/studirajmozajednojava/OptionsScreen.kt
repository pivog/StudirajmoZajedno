package com.example.studirajmozajednojava

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme

@Composable
fun OptionsScreen(
    onClickReset: () -> Unit
) {
    M3NavigationDrawerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.padding(20.dp)) {
                ElevatedButton(
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    ),
                    onClick = {
                        onClickReset()
                    }
                ) {
                    Text(
                        text = "Izbriši sve podatke",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OptionsScreenPreview() {
    OptionsScreen {

    }
}