package com.hutsy.dndgifts

import android.app.Application
import com.hutsy.datasource.local.di.localDatasourceModule
import com.hutsy.datasource.remote.di.remoteDatasourceModule
import com.hutsy.dndgifts.di.applicationModule
import com.hutsy.dndgifts.error.CrashHandler
import com.hutsy.dndgifts.error.CrashlyticsTree
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class DnDGiftsApp : Application() {
    val applicationScope: CoroutineScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        configureLogging()
        configureCrashHandler()
        configureKoin()
    }

    private fun configureLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(
                object : Timber.DebugTree() {
                    override fun createStackElementTag(element: StackTraceElement): String {
                        return super.createStackElementTag(element) + ":" + element.lineNumber
                    }
                },
            )
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }

    private fun configureCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(CrashHandler())
    }

    private fun configureKoin() {
        startKoin {
            androidLogger()
            androidContext(this@DnDGiftsApp)
            workManagerFactory()
            modules(
                applicationModule,
                localDatasourceModule,
                remoteDatasourceModule,
            )
        }
    }
}