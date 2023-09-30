package com.ragnorakdev.uirouter.entryPointTypes

import androidx.compose.runtime.Composable
import com.ragnorakdev.uirouter.EntryPointModule

data class ComposableDynamicFeaturePath(
    val methodNameView: @Composable () -> Unit
) : EntryPointModule