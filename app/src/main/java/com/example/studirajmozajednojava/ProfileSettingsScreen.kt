package com.example.studirajmozajednojava

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import java.util.Locale

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen(
    saveProsjek: (Double) -> Unit,
    saveSmijer: (String) -> Unit,
    saveRazred: (Int) -> Unit,
    prosjekCurrent: Double,
    smijerCurrent: String,
    razredCurrent: Int

) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp),
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "Profile Icon"
            )


            LocalContext.current
            val smjerovi = ArrayList<String>()
            Fakulteti.fakultetiList.forEach {
                    fakultet ->
                fakultet.smjerovi.forEach {
                        smijer ->
                    val smijerCapitalised = smijer.toString()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    if (smijerCapitalised !in smjerovi){
                        smjerovi.add(smijerCapitalised)
                    }
                }
            }
            smjerovi.sort()
            var expanded by remember { mutableStateOf(false) }
            var selectedText by remember { mutableStateOf(smijerCurrent) }


            Text(text = "Odabrani Smijer")
            Spacer(modifier = Modifier.height(10.dp))


            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    value = selectedText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    smjerovi.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedText = item
                                expanded = false
                            }
                        )
                    }
                }
            }


            val textState2 = rememberSaveable { mutableStateOf(prosjekCurrent.toString()) }
            var isError2 by rememberSaveable { mutableStateOf(false) }
            val errorMessage2 = "Molimo popunite ovo polje"

            fun validate2(text: String): Boolean {
                isError2 = text.isEmpty()
                return isError2
            }

            val keyboardController2 = LocalSoftwareKeyboardController.current

            Text(text = "Trenutni Prosjek")
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = textState2.value,
                trailingIcon = {
                    if (isError2)
                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
                },
                colors = TextFieldDefaults.colors(),
                onValueChange = {
                    if (it == "") {
                        textState2.value = it
                        return@OutlinedTextField
                    }
                    if (it.length > 5) {
                        return@OutlinedTextField
                    }
                    if ((it[it.lastIndex] == 'd') or (it[it.lastIndex] == 'f') or (it[it.lastIndex] == 'D') or (it[it.lastIndex] == 'F')) {
                        return@OutlinedTextField
                    }
                    if (it.toFloatOrNull() == null) {
                        return@OutlinedTextField
                    }
                    if (!((it.toFloat() >= 1) && (it.toFloat() <= 5))) {
                        return@OutlinedTextField
                    }
                    textState2.value = it
                },
                keyboardActions = KeyboardActions (onDone = {
                    keyboardController2?.hide()
                    validate2(textState2.value)
                }){
                    validate2(textState2.value)
                },
                singleLine = true,
                isError = isError2,
                supportingText = {
                    if (isError2) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = errorMessage2,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )


            val textState3 = remember { mutableStateOf(razredCurrent.toString()) }
            var isError3 by rememberSaveable { mutableStateOf(false) }
            val errorMessage3 = "Molimo popunite ovo polje"

            fun isEmpty(text: String): Boolean {
                isError3 = text.isEmpty()
                return isError3
            }

            Text(text = "Završenih Razreda srednje škole")
            Spacer(modifier = Modifier.height(10.dp))
            val keyboardController = LocalSoftwareKeyboardController.current
            OutlinedTextField(
                value = textState3.value,
                trailingIcon = {
                    if (isError3)
                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
                },
                colors = TextFieldDefaults.colors(),
                onValueChange = {
                    if (it == "") {
                        textState3.value = it
                        return@OutlinedTextField
                    }
                    if (it.length > 1) {
                        return@OutlinedTextField
                    }
                    if (it.toIntOrNull() == null) {
                        return@OutlinedTextField
                    }
                    if (!((it.toInt() >= 0) && (it.toInt() <= 4))) {
                        return@OutlinedTextField
                    }
                    textState3.value = it
                },
                keyboardActions = KeyboardActions (onDone = {
                    keyboardController?.hide()
                    if (isEmpty(textState3.value)) return@KeyboardActions
                }){
                    isEmpty(textState3.value)
                },
                singleLine = true,
                isError = isError3,
                supportingText = {
                    if (isError3) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = errorMessage3,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )


            ElevatedButton(
                modifier = Modifier.padding(0.dp , 50.dp, 0.dp, 40.dp),
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(6.dp),
                colors = ButtonDefaults.buttonColors(),
                onClick = {
                    if (isEmpty(textState2.value) or isEmpty(textState3.value)) return@ElevatedButton
                    saveProsjek(textState2.value.toDouble())
                    saveRazred(textState3.value.toInt())
                    saveSmijer(selectedText)
                }
            ) {
                Text(
                    text = "Spasi",
                    fontSize = 25.sp
                )
            }

        }
    }
}

@Preview
@Composable
private fun ProfileSettingsScreenPreview() {
    M3NavigationDrawerTheme {
        ProfileSettingsScreen(saveProsjek = { }, prosjekCurrent = 2.0, saveSmijer = { }, smijerCurrent = "Matematika", razredCurrent = 1, saveRazred = { })
    }
}