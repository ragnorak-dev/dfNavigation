package com.ragnorakdev.dynamicfeature_two.loader

import android.app.Activity
import com.ragnorakdev.dynamicfeature_two.MainSecondFeatureActivity
import com.ragnorakdev.ui_router.ModulesPackages
import com.ragnorakdev.uirouter.NavigationNameFeatures
import com.ragnorakdev.uirouter.Navigator
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath

class FeatureTwoEntryPointsLoader {

    init {
        Navigator.addAEntryPointRoute(
            NavigationNameFeatures.FEATURE_TWO,
            ActivityDynamicFeaturePath(MainSecondFeatureActivity::class.java as Class<Activity>)
        )
    }
}