plugins {
    alias(libs.plugins.dnd.android.library.compose)
}

android {
    namespace = "com.hutsy.auth.presentation"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.presentation.designsystem)
}