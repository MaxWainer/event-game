package ru.mgkit.event.game.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import org.koin.core.component.KoinComponent
import ru.mgkit.event.game.R

class EntryActivity : Activity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry)

        bindEnterButton()
        bindRegisterButton()
        bindLinks()
    }

    private fun bindRegisterButton() {
        val button = findViewById<Button>(R.id.register_button)

        button.setOnClickListener {
            val registerIntent = Intent(this@EntryActivity, RegisterActivity::class.java)

            this@EntryActivity.startActivity(registerIntent)
        }
    }

    private fun bindEnterButton() {
        val button = findViewById<ImageView>(R.id.join_view_button)

        button.setOnClickListener {
            val passwordData = resolveDataFromInputField(R.id.entry_password_field)
            val emailData = resolveDataFromInputField(R.id.entry_email_field)

            // fetch login logic
        }
    }

    private fun bindLinks() {
        fun bindLink(id: Int, link: String) {
            val button = findViewById<ImageView>(id)

            button.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(link) }

                startActivity(intent)
            }
        }

        bindLink(R.id.vk_link, "https://vk.com/")
        bindLink(R.id.google_link, "https://google.com/")
        bindLink(R.id.yandex_link, "https://yandex.com/")
        bindLink(R.id.leader_id_link, "https://leader-id.ru/")
    }

    private fun resolveDataFromInputField(id: Int): String {
        val field = findViewById<EditText>(id)

        return field.text.toString()
    }

}