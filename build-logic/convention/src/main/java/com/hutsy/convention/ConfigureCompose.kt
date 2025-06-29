package com.hutsy.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val composeBom = libs.findLibrary("androidx.compose.bom").get()
            "implementation"(libs.findLibrary("koin.androidx.compose").get())
            "androidTestImplementation"(platform(composeBom))
            "androidTestImplementation"(libs.findLibrary("androidx.compose.ui.test.junit4").get())
            "debugImplementation"(libs.findLibrary("androidx.compose.ui.tooling").get())
            "debugImplementation"(libs.findLibrary("androidx.compose.ui.test.manifest").get())
        }
    }
}