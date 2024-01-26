package com.example.studirajmozajednojava

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity

@Composable
fun PrikazFakulteta(
    packageContext: Context = LocalContext.current,
    save: (Fakulet) -> Unit,
    unsave: (Fakulet) -> Unit,
    isInFavorites: (Fakulet) -> Boolean,
    userTailoredList: List<Fakulet>
) {
    LazyColumn(
        modifier =
            Modifier.fillMaxSize()
    ) {
        userTailoredList.forEachIndexed {
                _, fakultet ->
            item {
                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                )
                fakultetUnit(
                    fakultet = fakultet,
                    save = {
                        save(fakultet)
                    },
                    unsave = {
                        unsave(fakultet)
                    },
                    inFavorites = isInFavorites(fakultet)
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
fun PrikazFakultetaPreview() {
    PrikazFakulteta(
        save = { },
        unsave = { },
        isInFavorites = { return@PrikazFakulteta false },
        userTailoredList = Fakulteti.fakultetiList.toList()
    )
}