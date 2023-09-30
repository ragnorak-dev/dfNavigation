package com.ragnorakdev.ui_router

enum class DynamicFeaturesLoadersNames(val moduleName: String, val loaderPath: String) {
    FEATURE_ONE("dynamicfeature_one", "${ModulesPackages.FEATURE_ONE}.loader.FeatureOneEntryPointsLoader"),
    FEATURE_TWO("dynamicfeature_two", "${ModulesPackages.FEATURE_TWO}.loader.FeatureTwoEntryPointsLoader"),
    FEATURE_THREE("dynamicfeature_three", "${ModulesPackages.FEATURE_THREE}.loader.FeatureThreeEntryPointsLoader")
}