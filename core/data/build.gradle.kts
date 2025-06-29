plugins {
    alias(libs.plugins.dnd.android.library)
}

android {
    namespace = "com.hutsy.core.data"

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
    implementation(libs.androidx.work)
    implementation(projects.core.domain)
}