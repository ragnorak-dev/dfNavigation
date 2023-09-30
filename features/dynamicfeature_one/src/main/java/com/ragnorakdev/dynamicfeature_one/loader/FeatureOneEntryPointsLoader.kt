package com.ragnorakdev.dynamicfeature_one.loader

import com.ragnorakdev.ui_router.ModulesPackages
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath

class FeatureOneEntryPointsLoader {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_ONE,
            ActivityDynamicFeaturePath("${ModulesPackages.FEATURE_ONE}.MainFirstFeatureActivity")
        )
    }

}