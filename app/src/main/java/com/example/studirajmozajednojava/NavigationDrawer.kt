package com.example.studirajmozajednojava

import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(navController: NavController, packageManager: PackageManager? = null, selectedItemIndex:MutableState<Int>, content: @Composable () -> Unit) {
    val items = listOf(
        NavigationItem(
            title = "Polazna",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "HomeRoute"
        ),
        NavigationItem(
            title = "Spašeni",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            route = "FavoritesRoute"
        ),
        NavigationItem(
            title = "Pretraži",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = "SearchRoute"
        ),
        NavigationItem(
            title = "Profil",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            route = "profileSettingsRoute"
        ),
        NavigationItem(
            title = "Postavke Za Testiranje",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "SettingsRoute"
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(
            drawerContent =
            {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, navigationItem ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = navigationItem.title)
                            },
                            selected = index == selectedItemIndex.value,
                            onClick = {
                                selectedItemIndex.value = index
                                scope.launch {
                                    drawerState.close()
                                    navController.navigate(navigationItem.route)
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selectedItemIndex.value == index) {
                                        navigationItem.selectedIcon
                                    } else {
                                        navigationItem.unselectedIcon
                                    },
                                    contentDescription = navigationItem.title
                                )
                            },
                            badge = {
                                if (navigationItem.badgeCount != null) {
                                    Text(text = navigationItem.badgeCount.toString())
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Studirajmo Zajedno")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(15.dp, paddingValues.calculateTopPadding(), 20.dp, paddingValues.calculateBottomPadding())) {
                    content()
                }
            }
        }
    }
}

@Composable
@Preview
fun NavigationDrawerPreview() {
    NavigationDrawer(navController = rememberNavController(), selectedItemIndex = remember{ mutableIntStateOf(0) }) {
        PrikazFakulteta(save = { }, unsave = { }, isInFavorites = { return@PrikazFakulteta false }, userTailoredList = Fakulteti.fakultetiList.toList())
    }
}