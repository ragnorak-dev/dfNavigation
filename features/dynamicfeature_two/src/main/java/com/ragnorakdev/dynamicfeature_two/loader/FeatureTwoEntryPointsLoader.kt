package com.ragnorakdev.dynamicfeature_two.loader

import com.ragnorakdev.ui_router.ModulesPackages
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath

class FeatureTwoEntryPointsLoader {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_TWO,
            ActivityDynamicFeaturePath("${ModulesPackages.FEATURE_TWO}.MainSecondFeatureActivity")
        )
    }
}