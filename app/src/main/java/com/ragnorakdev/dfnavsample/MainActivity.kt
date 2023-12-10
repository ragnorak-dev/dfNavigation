package com.ragnorakdev.dfnavsample

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ragnorakdev.dfnavigator.Navigator
import com.ragnorakdev.dfnavsample.ui.theme.MainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var navigate by remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = "Hello $name!, Main screen",
            modifier = modifier
        )

        Button(onClick = { navigate = true }) {
            Text(text = "Navigate to feature one")
        }
    }

    if (navigate) {
        Navigator.navigationTo(to = NavigationNameFeatures.FEATURE_ONE.moduleName)
        navigate = false
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainTheme {
        Greeting("Android")
    }
}