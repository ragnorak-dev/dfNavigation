package com.ragnorakdev.dynamicfeature_three

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThirdFeatureView() {
    Text(
        text = "Hello!, I'm Feature 3",
        modifier = Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ThirdFeatureView()
}