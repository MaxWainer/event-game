package ru.mgkit.event.game.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import org.koin.core.component.KoinComponent
import ru.mgkit.event.game.R

class RegisterActivity : Activity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val button = findViewById<Button>(R.id.dummy_reg_back)

        button.setOnClickListener {
            val intent = Intent(this@RegisterActivity, EntryActivity::class.java)

            startActivity(intent)
        }
    }

}