package com.ragnorakdev.dynamicfeature_one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ragnorakdev.dynamicfeature_one.ui.theme.UIRouterTheme
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator

class MainFirstFeatureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIRouterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var navigate by remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = "Hello $name!, FEATURE ONE!!!!",
            modifier = modifier
        )

        Button(onClick = { navigate = true }) {
            Text(text = "Navigate to feature two")
        }
    }

    if (navigate) {
        Navigator.NavigationTo(to = NavigationNameFeatures.FEATURE_TWO)
        navigate = false
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    UIRouterTheme {
        Greeting2("Android")
    }
}