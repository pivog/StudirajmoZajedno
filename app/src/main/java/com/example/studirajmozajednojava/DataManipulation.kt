package com.example.studirajmozajednojava

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.toLowerCase
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.Locale
import kotlin.math.abs


fun accessUserData(context: Context): DataStore<Preferences> {
    return context.createDataStore(name = "userData")
}

fun encodeSavedIndicies(indicies: ArrayList<Int>): String {
    return indicies.joinToString(separator = ",")
}

fun decodeSavedIndicies(indicies: String): ArrayList<Int> {
    val out: ArrayList<Int> = ArrayList()
    for (c in indicies.split(",")) {
        out.add(c.toInt())
    }
    return out
}

fun addToSaved(fakultet: Fakulet) {

}

suspend fun saveUserData(key: String, value:String, dataStore: DataStore<Preferences>) {
    val dataStoreKey = preferencesKey<String>(key)
    dataStore.edit {
            userData ->
        userData[dataStoreKey] = value
    }
}

suspend fun read(key: String, dataStore: DataStore<Preferences>): String {
    val dataStoreKey = preferencesKey<String>(key)
    val preferences = dataStore.data.first()
    if (preferences[dataStoreKey] == null) {
        return ""
    }
    val out: String = "" + preferences[dataStoreKey]
    return out
}

fun getFavorites(dataStore: DataStore<Preferences>): MutableList<Int> {
    var textData = runBlocking {
        var textDataDeffered = async {
            read("spaseniIndicies", dataStore)
        }
        return@runBlocking textDataDeffered.await()
    }
    if (textData == "") return mutableListOf()
    val out = MutableList(textData.split(" ").size) {
        textData.split(" ")[it].toInt()
    }
    return out
}

fun getFilteredAndSorted(smijer: String, prosjek: Double): List<Fakulet> {
    return Fakulteti.fakultetiList.filter {
        it.smjerovi.contains(smijer)
    }.sortedWith(compareBy { abs(it.difficulty - prosjek) })
}

fun getCities(): List<String> {
    val cities = ArrayList<String>()
    Fakulteti.fakultetiList.forEach { fakultet ->
        if (fakultet.city !in cities) cities.add(fakultet.city)
    }
    return cities.toList()
}