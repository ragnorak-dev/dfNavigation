package com.ragnorakdev.dynamicfeature_three.loader

import com.ragnorakdev.dfnavigator.Navigator
import com.ragnorakdev.dfnavigator.navigationViewTypes.ComposableDynamicFeaturePath
import com.ragnorakdev.dfnavigator.loaderpaths.LoaderDfNavigatorViews
import com.ragnorakdev.dynamicfeature_three.ThirdFeatureView
import com.ragnorakdev.dfnavsample.NavigationNameFeatures

class FeatureThreeEntryPointsLoader : LoaderDfNavigatorViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_THREE.moduleName,
            ComposableDynamicFeaturePath { ThirdFeatureView() }
        )
    }
}