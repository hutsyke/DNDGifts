plugins {
    alias(libs.plugins.dnd.android.library)
    alias(libs.plugins.dnd.jvm.ktor)
}

android {
    namespace = "com.hutsy.datasource.remote"

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