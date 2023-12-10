package com.ragnorakdev.dynamicfeature_three.loader

import com.ragnorakdev.dynamicfeature_three.ThirdFeatureView
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ComposableDynamicFeaturePath
import com.ragnorakdev.uirouter.loaderpaths.LoaderEntryViews

class FeatureThreeEntryPointsLoader : LoaderEntryViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_THREE,
            ComposableDynamicFeaturePath { ThirdFeatureView() }
        )
    }
}