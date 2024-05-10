package com.sopt.now.advanced.team2android.feature.model

import com.sopt.now.advanced.team2android.feature.R

enum class BottomNavItems(val id: Int) {
    HOME(R.id.homeFragment), SEARCH(R.id.searchFragment), MY_PAGE(R.id.myPageFragment);

    companion object {
        val bottomNavItems = listOf(HOME.id, SEARCH.id, MY_PAGE.id)
    }
}
