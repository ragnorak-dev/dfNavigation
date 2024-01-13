package com.ragnorakdev.dfnavigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ragnorakdev.dfnavigator.navigationViewTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.dfnavigator.navigationViewTypes.ComposableDynamicFeaturePath


object Navigator {
    
    private val activitiesRoutes: HashMap<String, NavigationViewModule> = hashMapOf()

    fun addAEntryPointRoute(id: String, route: NavigationViewModule) {
        activitiesRoutes[id] = route
    }

    fun removeEntryPoint(id: String) {
        activitiesRoutes.remove(id)
    }

    /**
     * Params:
     * to: Destination ID of navigation
     * infoBundle: Bundle to send info between Activities
     * registerForActivityResult: Callback Launcher get the result of an Activity
     *
     * Return: the result of navigation,
     * - true for the success navigation,
     * - false for the failure navigation
     */
    @Composable
    fun navigationTo(
        to: String,
        infoBundle: Bundle? = null,
        registerForActivityResult: ActivityResultLauncher<Intent>? = null
    ): Boolean =
        when {
            activitiesRoutes[to] is ActivityDynamicFeaturePath -> {
                navigateToDynamicFeature(
                    LocalContext.current,
                    (activitiesRoutes[to] as ActivityDynamicFeaturePath).dynamicFeaturePath,
                    infoBundle,
                    registerForActivityResult
                )
                true
            }

            activitiesRoutes[to] is ComposableDynamicFeaturePath -> {
                GetComposeViewFromFeature(activitiesRoutes[to] as ComposableDynamicFeaturePath)
                true
            }

            else -> {
               false
            }
        }

    private fun navigateToDynamicFeature(
        context: Context,
        to: Class<out Activity>,
        infoBundle: Bundle? = null,
        registerForActivityResult: ActivityResultLauncher<Intent>? = null
    ) {
        val intent = Intent(context, to)
        infoBundle?.let {
            intent.putExtras(it)
        }
        registerForActivityResult?.launch(intent) ?: context.startActivity(intent)
    }

    @Composable
    fun GetComposeViewFromFeature(to: ComposableDynamicFeaturePath) = to.methodNameView()
}