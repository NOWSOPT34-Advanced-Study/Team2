package com.sopt.now.advanced.team2android.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.sopt.now.advanced.team2android.data.model.Member
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemberDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : MemberDataSource {

    private object PreferencesKeys {
        val MEMBER_ID: Preferences.Key<String> = stringPreferencesKey("id")
        val MEMBER_PW: Preferences.Key<String> = stringPreferencesKey("pw")
        val MEMBER_NICKNAME: Preferences.Key<String> = stringPreferencesKey("nickname")
    }

    override suspend fun saveMemberToPreferencesStore(member: Member) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.MEMBER_ID] = member.id
            preferences[PreferencesKeys.MEMBER_PW] = member.pw
            member.nickname?.let {
                preferences[PreferencesKeys.MEMBER_NICKNAME] = it
            }
        }
    }

    override var id: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.MEMBER_ID] ?: "데이터 없음"
        }

    override var pw: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.MEMBER_PW] ?: "데이터 없음"
        }

    override var nickname: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { preferences ->
            preferences[PreferencesKeys.MEMBER_NICKNAME] ?: "데이터 없음"
        }
}