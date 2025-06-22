plugins {
    alias(libs.plugins.dnd.android.library.compose)
}

android {
    namespace = "com.hutsy.core.presentation.designsystem"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    dependencies {
        val composeBom = libs.androidx.compose.bom
        api(platform(composeBom))
        api(libs.androidx.material.icons.extended)
        api(libs.androidx.compose.ui)
        api(libs.androidx.compose.ui.graphics)
        api(libs.androidx.compose.ui.tooling.preview)
        api(libs.androidx.compose.material3)
        api(libs.coil.compose)
        api(libs.coil.svg)
    }
}