package com.ragnorakdev.uirouter.entryPointTypes

import android.app.Activity
import com.ragnorakdev.uirouter.EntryPointModule

data class ActivityDynamicFeaturePath(
    val dynamicFeaturePath: Class<out Activity>
) : EntryPointModule