package com.sopt.now.advanced.team2android.data.dataSource.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private const val SIGN_IN_PREFERENCES_NAME = "sign_in_preferences"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = SIGN_IN_PREFERENCES_NAME
)

class SettingDataStore(context: Context) {
    private val IS_SIGN_IN_MEMBER_MANAGER = booleanPreferencesKey("is_sign_in_member_manager")

    val preferenceFlow: Flow<Boolean> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[IS_SIGN_IN_MEMBER_MANAGER] ?: true
        }

    suspend fun saveMemberToPreferencesStore(isSignInMemberManager: Boolean, context: Context) {
        context.dataStore.edit { preferences ->
            preferences[IS_SIGN_IN_MEMBER_MANAGER] = isSignInMemberManager
        }
    }
}