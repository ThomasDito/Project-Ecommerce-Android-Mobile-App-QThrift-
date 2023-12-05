buildscript {
    val nav_version = "2.5.0"
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
        classpath ("com.google.gms:google-services:4.4.0")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

