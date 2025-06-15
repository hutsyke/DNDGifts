import com.android.build.api.dsl.ApplicationExtension
import com.hutsy.convention.configureKotlin
import com.hutsy.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                defaultConfig.applicationId = libs.findVersion("projectApplicationId").get().toString()
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                configureKotlin(this)
            }
        }
    }
}