# UIRouter-android

Here we have a example/template of how navigate between dynamic feature without dependencies between them


Make it in android studio Hedgehog, with gradle 8.2 and AGP 8.2

This architecture work in any gradle configuration.

This architecture is composed of two part:
- Load dynamic modules
- Navigate between dynamic modules

# Load dynamic modules

The module responsible of load the dynamic features is 'dfmanager' 
- This module has two classes:
   - DynamicFeatureLoader: It has the logic needed check if the module is installed and call to load it
   - LoaderDynamicEntriesPoints: Via reflection, it calls to LoaderModule class, this will be explained later on

# Navigate between dynamic modules

:construction: Under construction 
