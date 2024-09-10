// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val hilt_version by extra("2.50")
    val compose_version by extra("1.5.0")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
}