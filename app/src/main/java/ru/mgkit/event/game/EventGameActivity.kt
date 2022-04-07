package ru.mgkit.event.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.fileProperties
import ru.mgkit.event.game.di.HELPERS_MODULES
import ru.mgkit.event.game.di.VIEW_MODULES

class EventGameActivity : AppCompatActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            fileProperties()
            androidLogger(Level.DEBUG)
            androidContext(this@EventGameActivity)

            modules(VIEW_MODULES, HELPERS_MODULES)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        stopKoin()
    }

}