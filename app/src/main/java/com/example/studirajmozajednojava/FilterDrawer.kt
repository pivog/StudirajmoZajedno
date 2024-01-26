package com.example.studirajmozajednojava

import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studirajmozajednojava.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDrawer(packageManager: PackageManager? = null,
                 filters: MutableState<MutableMap<String, Boolean>>,
                 activeFakultetiList: MutableState<MutableList<Fakulet>>,
                 save: (Fakulet) -> Unit,
                 unsave: (Fakulet) -> Unit,
                 getFromQuery: (String) -> Unit,
) {
    val searchText = remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
            ModalNavigationDrawer(
                scrimColor = Color(0x00FFFFFF),
                drawerContent =
                {
                    ModalDrawerSheet {
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn (modifier = Modifier.width(200.dp)){
                            filters.value.keys.forEach { city ->
                                item {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Row (verticalAlignment = Alignment.CenterVertically){
                                        val checked = remember {
                                            mutableStateOf(filters.value.getValue(city))
                                        }
                                        Checkbox(checked = checked.value, onCheckedChange = {
                                            checked.value = it
                                            filters.value[city] = it
                                            getFromQuery(searchText.value)

                                        },
                                            colors = CheckboxDefaults.colors(
                                                uncheckedColor = MaterialTheme.colorScheme.outline,
                                                checkedColor = MaterialTheme.colorScheme.primary
                                            ))
                                        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                                            Text(text = city)
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                drawerState = drawerState
            ) {
                val scope = rememberCoroutineScope()
                Scaffold { paddingValues ->
                    Box(
                        modifier = Modifier.padding(
                            15.dp,
                            paddingValues.calculateTopPadding(),
                            20.dp,
                            paddingValues.calculateBottomPadding()
                        )
                    ) {
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr){
                            SearchScreen(
                                save = {
                                    save(it)
                                },
                                unsave = {
                                    unsave(it)
                                },
                                searchText = searchText,
                                getFromQuery = { getFromQuery(it) },
                                activeFakultetiList = activeFakultetiList,
                                openFilter = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun FilterDrawerPreview() {
    M3NavigationDrawerTheme {
        NavigationDrawer(navController = rememberNavController(), selectedItemIndex = remember{ mutableIntStateOf(0) }) {
            FilterDrawer(
                filters = remember {
                    mutableStateOf(mutableMapOf<String, Boolean>("Mostar" to true))
                },
                activeFakultetiList = remember { mutableStateOf(Fakulteti.fakultetiList.toMutableList()) },
                save = {},
                unsave = {}
            ) {

            }
        }
    }
}