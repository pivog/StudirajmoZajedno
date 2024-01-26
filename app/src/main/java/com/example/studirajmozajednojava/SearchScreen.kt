package com.example.studirajmozajednojava

import android.content.Context
import android.content.Intent
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.w3c.dom.Text

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    packageContext: Context = LocalContext.current,
    save: (Fakulet) -> Unit,
    unsave: (Fakulet) -> Unit,
    getFromQuery: (String) -> Unit,
    activeFakultetiList: MutableState<MutableList<Fakulet>>,
    searchText: MutableState<String>,
    openFilter: () -> Unit
) {
    val isSearching = MutableStateFlow(false)
    Column {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp, 10.dp, 5.dp)
        ){
            var isError by rememberSaveable { mutableStateOf(false) }

            fun isEmpty(text: String): Boolean {
                isError = text.isEmpty()
                return isError
            }

            val keyboardController = LocalSoftwareKeyboardController.current
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        color = MaterialTheme.colorScheme.outline,
                        text = "Pretraži"
                    )
                },
                value = searchText.value,
                onValueChange = {
                    searchText.value = it
                    getFromQuery(searchText.value)
                },
//                onValueChange = { newText ->
//                    searchText = newText
//                    listFakulteti = mutableStateListOf(*Fakulteti.fakultetiList)
//                    val listFakultetiFiltered = listFakulteti.filter {
//                        it.doesMatchSearchQuery(searchText)
//                    }
//                    listFakulteti = listFakultetiFiltered.toMutableList()
//                    Log.println(Log.DEBUG, "searchScreen", listFakulteti.size.toString())
//                },
                keyboardActions = KeyboardActions (onDone = {
                    keyboardController?.hide()
                }){

                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                )
            )
            IconButton(
                onClick = { openFilter() },
                modifier = Modifier
                ) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Filters Icon")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier =
            Modifier.fillMaxSize()
        ) {
            activeFakultetiList.value.forEachIndexed { _, fakulet ->
                item {
                    Box(
                        modifier = Modifier
                            .padding(10.dp, 0.dp)
                    )
                    fakultetUnit(
                        fakultet = fakulet,
                        save = { save(fakulet) },
                        unsave = { unsave(fakulet) },
                        inFavorites = false
                    )
                }
                item {
                    Surface {
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    M3NavigationDrawerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            SearchScreen(save = { }, unsave = { }, getFromQuery = { }, activeFakultetiList = remember { mutableStateOf(Fakulteti.fakultetiList.toMutableList()) }, searchText = remember { mutableStateOf("") },openFilter = {})
        }
    }
}