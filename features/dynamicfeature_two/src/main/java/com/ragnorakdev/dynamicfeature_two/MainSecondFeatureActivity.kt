package com.ragnorakdev.dynamicfeature_two

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
import com.ragnorakdev.dynamicfeature_two.ui.theme.UIRouterTheme
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator

class MainSecondFeatureActivity : ComponentActivity() {
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

    var showFeatureThree by remember { mutableStateOf(false) }
    var navigateSuccess by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = "Hello $name!, FEATURE TWO!!!! ALOHA!!!",
            modifier = modifier
        )

        Button(onClick = {
            showFeatureThree = showFeatureThree.not()
        }) {
            Text(text = "Navigate to feature three")
        }
        if (showFeatureThree) {
            navigateSuccess = Navigator.navigationTo(
                to = NavigationNameFeatures.FEATURE_THREE
            )
        }

        if (navigateSuccess.not()) {
            Text(
                text = "Navigation Error!!!!!!!",
                modifier = modifier
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    UIRouterTheme {
        Greeting2("Android")
    }
}