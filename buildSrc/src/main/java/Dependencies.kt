object Dependencies {
    //hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }

    //retro fit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    //couroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    val navcompose by lazy { "androidx.navigation:navigation-compose:${Versions.navcompose}" }

    //splash screen
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

    //coil
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    //accompanist-pager
    val pager by lazy { "com.google.accompanist:accompanist-pager:${Versions.pager}" }

    //swiperefresh
    val swiperefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.swiperefresh}" }


}
object Modules{
    const val utilities = ":utilities"
}