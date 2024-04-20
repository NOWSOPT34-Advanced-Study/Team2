package org.sopt.now.advenced.team2android.core.ui.util.context

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context.stringOf(
    @StringRes resId: Int
) = getString(resId)

fun Context.colorOf(
    @ColorRes resId: Int
) = ContextCompat.getColor(this, resId)
