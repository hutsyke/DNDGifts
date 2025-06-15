package tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class BumperVersionMajorTask @Inject constructor(execOperations: ExecOperations) : BaseBumperTask(execOperations) {

    @TaskAction
    fun bumperVersionMajor() {
        val (major, _, _, _) = getVersionNameList
        val versionName = "${major.toInt() + 1}.0.0.0"
        val versionCode = incrementVersionCode()

        save(versionName, versionCode)
    }

}