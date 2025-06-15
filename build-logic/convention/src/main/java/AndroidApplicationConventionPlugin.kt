import com.android.build.api.dsl.ApplicationExtension
import com.hutsy.convention.configureKotlin
import com.hutsy.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import tasks.configureBumperTasks
import java.util.Properties

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            tasks.run { configureBumperTasks(this) }

            val propertiesFile = project.rootProject.file("versions.properties")
            val properties = Properties().apply {
                if (propertiesFile.exists()) {
                    load(propertiesFile.inputStream())
                } else {
                    propertiesFile.createNewFile()
                }
            }

            val versionCode = properties.getProperty("versionCode")
            val versionName = properties.getProperty("versionName")

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                defaultConfig.applicationId = libs.findVersion("projectApplicationId").get().toString()
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                defaultConfig.versionCode = versionCode.toIntOrNull() ?: 1
                defaultConfig.versionName = versionName

                configureKotlin(this)
            }
        }
    }
}