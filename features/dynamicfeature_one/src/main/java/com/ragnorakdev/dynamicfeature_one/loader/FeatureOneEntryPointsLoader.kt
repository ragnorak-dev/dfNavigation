package com.ragnorakdev.dynamicfeature_one.loader

import com.ragnorakdev.dfnavigator.Navigator
import com.ragnorakdev.dfnavigator.navigationViewTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.dfnavigator.loaderpaths.LoaderDfNavigatorViews
import com.ragnorakdev.dynamicfeature_one.MainFirstFeatureActivity
import com.ragnorakdev.dfnavsample.NavigationNameFeatures

class FeatureOneEntryPointsLoader : LoaderDfNavigatorViews {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_ONE.moduleName,
            ActivityDynamicFeaturePath(MainFirstFeatureActivity::class.java)
        )
    }

}