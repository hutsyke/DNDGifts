package tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class BumperVersionPatchTask @Inject constructor(execOperations: ExecOperations) : BaseBumperTask(execOperations) {

    @TaskAction
    fun bumperVersionPatch() {
        val (major, minor, patch, _) = getVersionNameList
        val versionName = "$major.$minor.${patch.toInt() + 1}.0"
        val versionCode = incrementVersionCode()

        save(versionName, versionCode)
    }

}