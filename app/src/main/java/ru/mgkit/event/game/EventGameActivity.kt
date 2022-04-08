package ru.mgkit.event.game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import ru.mgkit.event.game.activity.EntryActivity
import ru.mgkit.event.game.di.HELPERS_MODULES
import ru.mgkit.event.game.di.REPOSITORIES_MODULES
import ru.mgkit.event.game.di.VIEW_MODULES

class EventGameActivity : AppCompatActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@EventGameActivity)

            modules(VIEW_MODULES, HELPERS_MODULES, REPOSITORIES_MODULES)
        }

        val button = findViewById<Button>(R.id.entry_button)

        button.setOnClickListener {
            val entryIntent = Intent(this@EventGameActivity, EntryActivity::class.java)

            this@EventGameActivity.finish()

            startActivity(entryIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        stopKoin()
    }

}