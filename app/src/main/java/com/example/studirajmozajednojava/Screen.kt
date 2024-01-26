package com.example.studirajmozajednojava

sealed class Screen(val route: String) {
    object Search: Screen(route = "SearchRoute")
    object PrikazList: Screen(route = "PrikazRoute")
    object Home: Screen(route = "HomeRoute")
    object Settings: Screen(route = "SettingsRoute")
    object Favorites: Screen(route = "FavoritesRoute")
    object Evaluation1: Screen(route = "Evaluation1")
    object Evaluation2: Screen(route = "Evaluation2")
    object Evaluation3: Screen(route = "Evaluation3")
    object Evaluation4: Screen(route = "Evaluation4")
    object PopupInfo: Screen(route = "PopupInfoRoute")
    object ProfileSettings: Screen(route = "profileSettingsRoute")
}