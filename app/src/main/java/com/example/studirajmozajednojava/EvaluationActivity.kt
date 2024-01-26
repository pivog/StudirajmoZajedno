package com.example.studirajmozajednojava

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import java.util.Locale

class EvaluationActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private lateinit var dataStore: DataStore<Preferences>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3NavigationDrawerTheme {
                dataStore = createDataStore("userData")
                navController = rememberNavController()
                SetupNavHostEvaluationProcess(LocalContext.current, navController = navController, lifecycle = lifecycleScope, dataStore = dataStore)
            }
        }
    }
}

@Composable
fun Evaluation1(
    navHostController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(550),
                text = "Dobrodošli u Studirajmo Zajedno",
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Pronađite najbolji fakultet za sebe već danas. Uz pomoć naše aplikacije!",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Box(
                modifier = Modifier
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ){
                ElevatedButton(
                    modifier = Modifier.padding(0.dp , 70.dp, 0.dp, 0.dp),
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        navHostController.navigate(Screen.Evaluation2.route)
                    }
                ) {
                    Text(
                        text = "Započnimo!",
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evaluation2(
    onClickNext: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(550),
                text = "Upišite Podatke",
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Odaberite studij za koji ste zainteresirani",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )


            LocalContext.current
            val smjerovi = ArrayList<String>()
            Fakulteti.fakultetiList.forEach {
                fakultet ->
                fakultet.smjerovi.forEach {
                        smijer ->
                    val smijerCapitalised = smijer.toString()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    if (smijerCapitalised !in smjerovi && smijerCapitalised.trim() != ""){
                        smjerovi.add(smijerCapitalised)
                    }
                }
            }
            smjerovi.sort()
            var expanded by remember { mutableStateOf(false) }
            var selectedText by remember { mutableStateOf(smjerovi[0]) }

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 150.dp),
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

            Box(
                modifier = Modifier
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ){
                ElevatedButton(
                    modifier = Modifier.padding(0.dp , 70.dp, 0.dp, 0.dp),
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        onClickNext(selectedText)
                    }
                ) {
                    Text(
                        text = "Nastavi",
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Evaluation3(
    onClickNext: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(550),
                text = "Upišite Podatke",
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Koji vam je trenutni prosjek?",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )

            val textState = rememberSaveable { mutableStateOf("") }
            var isError by rememberSaveable { mutableStateOf(false) }
            val errorMessage = "Molimo popunite ovo polje"

            fun validate(text: String): Boolean {
                isError = text.isEmpty()
                return isError
            }

            val keyboardController = LocalSoftwareKeyboardController.current
            OutlinedTextField(
                value = textState.value,
                trailingIcon = {
                    if (isError)
                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
                },
                colors = TextFieldDefaults.colors(),
                onValueChange = {
                    if (it == "") {
                        textState.value = it
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
                    textState.value = it
                },
                keyboardActions = KeyboardActions (onDone = {
                    keyboardController?.hide()
                    validate(textState.value)
                    onClickNext(textState.value)
                }){
                    validate(textState.value)
                  },
                singleLine = true,
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )

            Box(
                modifier = Modifier
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ){
                ElevatedButton(
                    modifier = Modifier.padding(0.dp , 70.dp, 0.dp, 0.dp),
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        if (validate(textState.value)) {
                            return@ElevatedButton
                        }
                        onClickNext(textState.value)
                    }
                ) {
                    Text(
                        text = "Nastavi",
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Evaluation4(
    onClickNext: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(550),
                text = "Upišite Podatke",
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Koliko ste razreda srednje škole završili?",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )


            val textState = remember { mutableStateOf("") }
            var isError by rememberSaveable { mutableStateOf(false) }
            val errorMessage = "Molimo popunite ovo polje"

            fun isEmpty(text: String): Boolean {
                isError = text.isEmpty()
                return isError
            }

            val keyboardController = LocalSoftwareKeyboardController.current
            OutlinedTextField(
                value = textState.value,
                trailingIcon = {
                    if (isError)
                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
                },
                colors = TextFieldDefaults.colors(),
                onValueChange = {
                    if (it == "") {
                        textState.value = it
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
                    textState.value = it
                },
                keyboardActions = KeyboardActions (onDone = {
                    keyboardController?.hide()
                    if (isEmpty(textState.value)) return@KeyboardActions
                    onClickNext(textState.value)
                }){
                    isEmpty(textState.value)
                },
                singleLine = true,
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )


//            OutlinedTextField(
//                value = textState.value,
//                isError = isError,
//                trailingIcon = {
//                    if (isError)
//                        Icon(Icons.Filled.Info,"error", tint = MaterialTheme.colorScheme.error)
//                },
//                supportingText = {
//                    if (isError) {
//                        Text(
//                            modifier = Modifier.fillMaxWidth(),
//                            text = errorMessage,
//                            color = MaterialTheme.colorScheme.error
//                        )
//                    }
//                },
//                onValueChange = {
//                    Toast.makeText(context, "${textState.value}    $it", Toast.LENGTH_LONG).show()
//                    if (it == "") {
//                        textState.value = it
//                        return@OutlinedTextField
//                    }
//                    if (it.toIntOrNull() == null) {
//                        return@OutlinedTextField
//                    }
//                    if (!((it.toInt() >= 0) && (it.toInt() <= 4))) {
//                        return@OutlinedTextField
//                    }
//                    textState.value = it
//                },
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Done
//                ),
//                keyboardActions = KeyboardActions { validate(textState.value) },
//                singleLine = true,
//            )

            Box(
                modifier = Modifier
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ){
                ElevatedButton(
                    modifier = Modifier.padding(0.dp , 70.dp, 0.dp, 0.dp),
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        if (isEmpty(textState.value)) return@ElevatedButton
                        onClickNext(textState.value)
                    }
                ) {
                    Text(
                        text = "Nastavi",
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Evaluation1Preview() {
    M3NavigationDrawerTheme {
        Evaluation1(NavHostController(LocalContext.current))
    }
}

@Preview(showBackground = true)
@Composable
fun Evaluation2Preview() {
    M3NavigationDrawerTheme {
        Evaluation2(
            onClickNext = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Evaluation3Preview() {
    M3NavigationDrawerTheme {
        Evaluation3 {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Evaluation4Preview() {
    M3NavigationDrawerTheme {
        Evaluation4 {

        }
    }
}

