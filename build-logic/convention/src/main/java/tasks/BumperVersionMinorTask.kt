package tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class BumperVersionMinorTask @Inject constructor(execOperations: ExecOperations) : BaseBumperTask(execOperations) {

    @TaskAction
    fun bumpVersionMinor() {
        val (major, minor, _, _) = getVersionNameList
        val versionName = "$major.${minor.toInt() + 1}.0.0"
        val versionCode = incrementVersionCode()

        save(versionName, versionCode)
    }

}