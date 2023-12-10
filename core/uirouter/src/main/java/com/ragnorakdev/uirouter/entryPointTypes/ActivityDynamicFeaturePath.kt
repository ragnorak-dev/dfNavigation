package com.ragnorakdev.uirouter.entryPointTypes

import android.app.Activity
import com.ragnorakdev.uirouter.EntryViewModule

data class ActivityDynamicFeaturePath(
    val dynamicFeaturePath: Class<out Activity>
) : EntryViewModule