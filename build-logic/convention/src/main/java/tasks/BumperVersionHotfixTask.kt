package tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class BumperVersionHotfixTask @Inject constructor(execOperations: ExecOperations) : BaseBumperTask(execOperations) {
    @TaskAction
    fun bumperVersionHotFix() {
        val (major, minor, patch, hotfix) = getVersionNameList
        val versionName = "$major.$minor.$patch.${hotfix.toInt() + 1}"
        val versionCode = incrementVersionCode()

        save(versionName, versionCode)
    }
}