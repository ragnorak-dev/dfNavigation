package com.ragnorakdev.dfnavigator.navigationViewTypes

import androidx.compose.runtime.Composable
import com.ragnorakdev.dfnavigator.NavigationViewModule

data class ComposableDynamicFeaturePath(
    val methodNameView: @Composable () -> Unit
) : NavigationViewModule