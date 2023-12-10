package com.ragnorakdev.dynamicfeature_one.loader

import com.ragnorakdev.dynamicfeature_one.MainFirstFeatureActivity
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.uirouter.loaderpaths.LoaderEntryViews

class FeatureOneEntryPointsLoader : LoaderEntryViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_ONE,
            ActivityDynamicFeaturePath(MainFirstFeatureActivity::class.java)
        )
    }

}