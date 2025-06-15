package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.process.ExecOperations
import java.io.File
import java.util.Properties

abstract class BaseBumperTask (
    private val execOperations: ExecOperations
) : DefaultTask() {
    @OutputFile
    val versionsFile: File = project.rootProject.file("versions.properties")

    @Input
    val properties = Properties().apply {
        if (versionsFile.exists()) {
            load(versionsFile.inputStream())
        } else {
            versionsFile.createNewFile()
        }
    }

    @get:Input
    val getVersionNameList: List<String>
        get() = properties["versionName"].toString().split(".")

    @get:Input
    private val getVersionCode: String
        get() = properties["versionCode"].toString()

    fun incrementVersionCode(): String = (getVersionCode.toIntOrNull()?.plus(1))?.toString() ?: "1"

    fun save(versionName: String, versionCode: String) {
        properties["versionName"] = versionName
        properties["versionCode"] = versionCode

        properties.store(versionsFile.outputStream(), null)

        execOperations.exec {
            commandLine("git", "add", versionsFile.absolutePath)
        }

        execOperations.exec {
            commandLine("git", "commit", "-m", "Bump version to $versionName ($versionCode)")
        }
    }
}