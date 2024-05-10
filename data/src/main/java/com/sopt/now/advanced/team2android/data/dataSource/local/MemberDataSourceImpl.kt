package com.sopt.now.advanced.team2android.data.dataSource.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val SIGN_IN_PREFERENCES_NAME = "sign_in_preferences"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = SIGN_IN_PREFERENCES_NAME
)

class MemberDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context,
) : MemberDataSource {
    private val IS_SIGN_IN_MEMBER_MANAGER = booleanPreferencesKey("is_sign_in_member_manager")

    private object PreferencesKeys {
        val MEMBER_ID: Preferences.Key<String> = stringPreferencesKey("id")
        val MEMBER_PW: Preferences.Key<String> = stringPreferencesKey("pw")
    }

    val idPreferencesFlow: Flow<String> = context.dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.MEMBER_ID] ?: ""
        }

    val pwPreferencesFlow: Flow<String> = context.dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.MEMBER_PW] ?: ""
        }


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

    override var id: String
        get() = ""
        set(value) {}
    override var pw: String
        get() = ""
        set(value) {}

}