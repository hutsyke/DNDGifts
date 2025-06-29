plugins {
    alias(libs.plugins.dnd.android.room)
}

android {
    namespace = "com.hutsy.datasource.local"

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
    implementation(libs.preference.datastore)

    implementation(projects.core.data)
    implementation(projects.core.domain)
}