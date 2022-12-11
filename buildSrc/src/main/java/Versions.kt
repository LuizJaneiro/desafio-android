import Libs.VersionNumber.androidTest
import Libs.VersionNumber.coroutines
import Libs.VersionNumber.espresso
import Libs.VersionNumber.gradleVersion
import Libs.VersionNumber.koin
import Libs.VersionNumber.koinExt
import Libs.VersionNumber.kotlinVersion
import Libs.VersionNumber.lifecycle
import Libs.VersionNumber.navigation
import Libs.VersionNumber.room

object Libs {
    object VersionNumber {
        const val kotlinVersion = "1.6.21"
        const val gradleVersion = "7.2.2"
        const val coreKtx = "1.8.0"

        const val appCompat = "1.5.0"
        const val constraintLayout = "2.1.4"
        const val material = "1.2.0"

        const val koin = "3.1.5"
        const val koinExt = "3.0.2"
        const val koinAndroidExt = "2.2.3"

        const val lifecycle = "2.5.1"
        const val coroutines = "1.6.4"

        const val gson = "2.8.6"
        const val retrofit = "2.9.0"
        const val okHttp = "4.9.0"

        const val picasso = "2.71828"
        const val circleImageView = "3.0.0"

        const val jUnit = "4.13.2"
        const val mockk = "1.12.3"
        const val coreTesting = "2.1.0"
        const val androidTest = "1.4.0-rc01"
        const val espresso = "3.2.0"

        const val navigation = "2.5.1"
        const val room = "2.4.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:$gradleVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinAndroidExtensions = "org.jetbrains.kotlin:kotlin-android-extensions-runtime:$kotlinVersion"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val coreKtx = "androidx.core:core-ktx:${VersionNumber.coreKtx}"

    const val appCompat =  "androidx.appcompat:appcompat:${VersionNumber.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${VersionNumber.constraintLayout}"
    const val material = "com.google.android.material:material:${VersionNumber.material}"

    const val koinCore = "io.insert-koin:koin-core:$koin"
    const val koinCoreExt = "io.insert-koin:koin-core-ext:$koinExt"
    const val koinAndroid = "io.insert-koin:koin-android:$koin"
    const val koinAndroidCompat = "io.insert-koin:koin-android-compat:$koin"

    const val lifecycleViewModelKtx =  "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle"
    const val lifecycleRuntimeKtx =  "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:$lifecycle"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines"

    const val gson = "com.google.code.gson:gson:${VersionNumber.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${VersionNumber.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${VersionNumber.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${VersionNumber.okHttp}"
    const val okHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${VersionNumber.okHttp}"

    const val picasso = "com.squareup.picasso:picasso:${VersionNumber.picasso}"
    const val circleImageView =  "de.hdodenhof:circleimageview:${VersionNumber.circleImageView}"

    const val jUnit = "junit:junit:${VersionNumber.jUnit}"
    const val mockk = "io.mockk:mockk:${VersionNumber.mockk}"
    const val coreTesting = "androidx.arch.core:core-testing:${VersionNumber.coreTesting}"
    const val koinTest = "io.insert-koin:koin-test:$koin"

    const val testRunner = "androidx.test:runner:$androidTest"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espresso"
    const val testCoreKtx = "androidx.test:core:$androidTest"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigation"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigation"

    const val roomRuntime = "androidx.room:room-runtime:$room"
    const val roomCompiler = "androidx.room:room-compiler:$room"
    const val roomKtx = "androidx.room:room-ktx:$room"
}