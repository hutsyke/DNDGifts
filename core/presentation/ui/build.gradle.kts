plugins {
    alias(libs.plugins.dnd.android.library.compose)
}

android {
    namespace = "com.hutsy.core.presentation.ui"

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
    implementation(projects.core.presentation.designsystem)
}