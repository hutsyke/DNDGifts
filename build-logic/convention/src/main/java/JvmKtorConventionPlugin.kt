import com.android.build.api.dsl.LibraryExtension
import com.hutsy.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class JvmKtorConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                "implementation"(libs.findBundle("ktor").get())
            }
        }
    }
}