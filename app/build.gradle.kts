plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.picpay.desafio.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "API_URL", "\"https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/\"")
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_URL", "\"https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/\"")
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    namespace = "com.picpay.desafio.android"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlinStdLib)
    implementation(Libs.kotlinAndroidExtensions)

    implementation(Libs.coreKtx)

    implementation(Libs.appCompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.material)

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinCoreExt)
    implementation(Libs.koinAndroidCompat)

    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    implementation(Libs.lifecycleCommon)
    implementation(Libs.lifecycleRuntimeKtx)
    implementation(Libs.lifecycleViewModelKtx)

    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.gson)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.okHttp)
    implementation(Libs.okHttpMockWebServer)

    implementation(Libs.picasso)
    implementation(Libs.circleImageView)

    implementation(Libs.navigationUi)
    implementation(Libs.navigationFragment)

    testImplementation(Libs.jUnit)
    testImplementation(Libs.mockk)
    testImplementation(Libs.coreTesting)
    implementation(Libs.koinTest)

    androidTestImplementation(Libs.testRunner)
    androidTestImplementation(Libs.espressoCore)
    androidTestImplementation(Libs.testCoreKtx)
}

