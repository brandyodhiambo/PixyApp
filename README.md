<p align="center">

# PixyApp
  Pixy app is a simple application the make use of [Pixabay](https://pixabay.com/api/docs/#api_search_images) API to display any picture one would query from the api.My Main aim was to learn the following concepts
  - Mvvm 
  - Retrofit
  - Dependency injection with dagger hilt
  - Offline caching with Room Database
  
Min Api Level : 21

## Setup Requirements

- Android device or emulator
- Android Studio

## Getting Started

In order to get the app running yourself, you need to:

1.  clone this project
2.  Import the project into Android Studio
3.  Connect the android device with USB or just use your emulator
4.  In Android Studio, click on the "Run" button.

## Libraries

Libraries used in the whole application are:

- [Kotlin](https://developer.android.com/kotlin) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin
- [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) -  Helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- [Room Persistance library](https://developer.android.com/training/data-storage/room)-Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite
- [Android KTX](https://developer.android.com/kotlin/ktx)-Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
- [LifeCycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)-Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain. 
- [Hilt-Dagger](https://developer.android.com/training/dependency-injection/hilt-android) - Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Doing manual dependency injection requires you to construct every class and its dependencies by hand, and to use containers to reuse and manage dependencies.
- [MVVM](https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/) - MVVM stands for Model, View, ViewModel. Model: This holds the data of the application. It cannot directly talk to the View. Generally, it's recommended to expose the data to the ViewModel through Observables.
- [Glide](https://guides.codepath.com/android/Displaying-Images-with-the-Glide-Library) - Glide is an Image Loader Library for Android developed by bumptech and is a library that is recommended by Google. It has been used in many Google open source projects including Google I/O 2014 official application. It provides animated GIF support and handles image loading/caching. 
- [Timber](https://github.com/JakeWharton/timber)- Timber is a logging utility class built on top of Android's Log class. While in development, we usually end up writing lot of log statements and before the release, we'll cleanup the log statements by removing them manually (even though logs can be disabled in release build)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - Coroutines are computer program components that generalize subroutines for non-preemptive multitasking, by allowing execution to be suspended and resumed. Coroutines are well-suited for implementing familiar program components such as cooperative tasks, exceptions, event loops, iterators, infinite lists and pipes
- [Kotlin Flows](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. For example, you can use a flow to receive live updates from a database.
- [Retrofit](https://abhiandroid.com/programming/retrofit) - In Android, Retrofit is a REST Client for Java and Android by Square inc under Apache 2.0 license. Its a simple network library that used for network transactions. By using this library we can seamlessly capture JSON response from web service/web API.
## Demo
<p float="left">
<img src="screenshoots/Screenshot_20220308-060010.png" width=250/>
<img src="screenshoots/Screenshot_20220308-060033.png" width=250/>
<img src="screenshoots/Screenshot_20220308-060127.png" width=250/>
<img src="screenshoots/Screenshot_20220308-060156.png" width=250/>
<img src="screenshoots/Screenshot_20220308-060221.png" width=250/>
<img src="screenshoots/Screenshot_20220308-060254.png" width=250/>
</p>
  
## Support
- Found this project useful ❤️? Support by clicking the ⭐️ button on the upper right of this page. ✌️
- Notice anything else missing? File an issue 
- Feel free to contribute in any way to the project from typos in docs to code review are all welcome.
