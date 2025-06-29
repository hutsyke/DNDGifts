plugins {
    alias(libs.plugins.dnd.android.library)
}

android {
    namespace = "com.hutsy.auth.data"

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
    implementation(projects.core.data)
    implementation(projects.core.domain)
}