buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
