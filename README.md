# DF Navigator - Android

Here we have a example/template of how navigate between dynamic feature without dependencies between them


Make it in android studio Hedgehog, with gradle 8.2 and AGP 8.2

This architecture work in any gradle configuration.

This architecture is composed of two part:
- Load dynamic modules
- Navigate between dynamic modules

# Load dynamic modules

The first step is create in each dynamic feature a implementation of `LoaderDfNavigatorViews` interface:
- this implementation is the responsible of give all `NavigationViewModule` of the module to 'Navigator' class
Once this is created, It's need to call to `DfNavigatorProvider` in the app Manifest adding as metadata each Loader path

  
# Navigate between dynamic modules

The Navigator class has listed all Entry Points with they identifiers in a map.

This class, also, has the `navigationTo` function to navigate to identifier given

The sequence diagram is:

![show df view sequence diagram drawio](https://github.com/ragnorak-dev/UIRouter-android/assets/7957314/4c15f010-765d-45d7-8c95-b01f52183abc)

