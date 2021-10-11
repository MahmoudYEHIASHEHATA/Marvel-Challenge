# Marvel-Challenge
A simple Android project that lists, details and search Marvel characters.

# Architecture

I choose to use MVVM (Model-View-ViewModel) as my project architecture in order to provide a cleaner code, with clear separation between the view, the data and the business logic. The following diagram shows all the modules and how each module interact with one another after. This architecture using a layered software architecture. 

![MVVM](https://user-images.githubusercontent.com/55722619/81968739-a8bec700-95d1-11ea-8682-48fe879c25ff.png)

# Work in progress 🚧
following features are ready :

- All dependencies inserted with Gradle
- Project organized in modules by features;
- Project built structer use concept of [Onion Architecture](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)
- Static code analysis.

# Features 🎨
- Paginated listing of the character's name and image.
- Display the description, comics, series, stores and events of the character that the user selects.
- Search for the character by the name.

# Tools 🔨
This project was built in Kotlin and designed according to the MVVM and Clean architectures using:

- ViewModel: The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
- LiveData: [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
- Coroutines: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) not only open the doors to asynchronous programming, but also provide a wealth of other possibilities such as concurrency, actors, etc.
- Dagger Hilt: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- Material Components: [Material Components](https://material.io/components?platform=android) are interactive building blocks for creating a user interface.
- Navigation: [Android Jetpack's Navigation component](https://developer.android.com/guide/navigation) helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- Retrofit: A [type-safe HTTP client](https://square.github.io/retrofit/) for Android and the JVM.
- RoomDataBase : Save data in a local database using [Room](https://developer.android.com/training/data-storage/room)
- Glide : [image loading](https://github.com/bumptech/glide) framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

# Static Analysis 🔍
This project uses [detekt](https://github.com/detekt/detekt) to analyze the source code.
