plugins {
    `kotlin-dsl`
}

group = "com.hutsy.dndgifts.buildLogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("androidApplication") {
            implementationClass = "AndroidApplicationConventionPlugin"
            id = "dnd.android.application"
        }

        create("androidApplicationCompose") {
            implementationClass = "AndroidApplicationComposeConventionPlugin"
            id = "dnd.android.application.compose"
        }

        create("androidLibrary") {
            implementationClass = "AndroidLibraryConventionPlugin"
            id = "dnd.android.library"
        }

        create("androidLibraryCompose") {
            implementationClass = "AndroidLibraryComposeConventionPlugin"
            id = "dnd.android.library.compose"
        }

        create("jvmLibrary") {
            implementationClass = "JvmLibraryConventionPlugin"
            id = "dnd.jvm.library"
        }

        create("androidRoom") {
            implementationClass = "AndroidRoomConventionPlugin"
            id = "dnd.android.room"
        }

        create("jvmKtor") {
            implementationClass = "JvmKtorConventionPlugin"
            id = "dnd.jvm.ktor"
        }
    }
}