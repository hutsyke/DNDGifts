package tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class BumperInit @Inject constructor(execOperations: ExecOperations) : BaseBumperTask(execOperations) {
    @TaskAction
    fun bumperInit() {
        val versionName = project.findProperty("versionName")?.toString()
            ?: "1.0.0.0"

        val versionCode = project.findProperty("versionCode")?.toString()
            ?: "1"

        save(versionName, versionCode)
    }
}