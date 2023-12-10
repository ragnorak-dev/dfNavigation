package com.ragnorakdev.dynamicfeature_two.loader

import com.ragnorakdev.dynamicfeature_two.MainSecondFeatureActivity
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.uirouter.loaderpaths.LoaderEntryViews

class FeatureTwoEntryPointsLoader : LoaderEntryViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_TWO,
            ActivityDynamicFeaturePath(MainSecondFeatureActivity::class.java)
        )
    }
}