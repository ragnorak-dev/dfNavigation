package com.ragnorakdev.dynamicfeature_two.loader

import com.ragnorakdev.dfnavigator.Navigator
import com.ragnorakdev.dfnavigator.navigationViewTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.dfnavigator.loaderpaths.LoaderDfNavigatorViews
import com.ragnorakdev.dynamicfeature_two.MainSecondFeatureActivity
import com.ragnorakdev.dfnavsample.NavigationNameFeatures

class FeatureTwoEntryPointsLoader : LoaderDfNavigatorViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_TWO.moduleName,
            ActivityDynamicFeaturePath(MainSecondFeatureActivity::class.java)
        )
    }
}