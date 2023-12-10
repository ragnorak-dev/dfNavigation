package com.ragnorakdev.dfnavigator.navigationViewTypes

import android.app.Activity
import com.ragnorakdev.dfnavigator.NavigationViewModule

data class ActivityDynamicFeaturePath(
    val dynamicFeaturePath: Class<out Activity>
) : NavigationViewModule