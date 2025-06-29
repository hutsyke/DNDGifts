import androidx.room.gradle.RoomExtension
import com.android.build.api.dsl.LibraryExtension
import com.hutsy.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("dnd.android.library")
                apply("androidx.room")
                apply("com.google.devtools.ksp")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                dependencies {
                    "implementation"(libs.findLibrary("room.ktx").get())
                    "implementation"(libs.findLibrary("room.runtime").get())
                    "ksp"(libs.findLibrary("room.compiler").get())
                }
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }
        }
    }
}