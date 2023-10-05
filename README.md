# UIRouter-android

Here we have a example/template of how navigate between dynamic feature without dependencies between them


Make it in android studio Hedgehog, with gradle 8.2 and AGP 8.2

This architecture work in any gradle configuration.

This architecture is composed of two part:
- Load dynamic modules
- Navigate between dynamic modules

# Load dynamic modules

The module responsible for loading the dynamic features is 'dfmanager'
- This module has two classes:
  - DynamicFeatureLoader: It has the logic needed to  check if the module is installed and call to load it
  - LoaderDynamicEntriesPoints: Via reflection, it calls to LoaderModule class, this will be explained later on
- In other instance, each dynamic feature have a '{FeatureName}EntryPointsLoader', this class will be responsible of give all 'EntryPoint' of the module to 'Navigator' class
- The app has 'DynamicFeaturesLoadersNames', where all paths of the '{FeatureName}EntryPointsLoader' are stored to call it via reflection.


The sequence diagram is:
![Load dynamic features sequence diagram drawio](https://github.com/ragnorak-dev/UIRouter-android/assets/7957314/95791faf-8bd4-43a3-be4b-3768a76819c3)


# Navigate between dynamic modules

:construction: Under construction 
