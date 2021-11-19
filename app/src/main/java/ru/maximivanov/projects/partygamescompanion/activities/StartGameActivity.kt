package ru.maximivanov.projects.partygamescompanion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import ru.maximivanov.projects.partygamescompanion.R

class StartGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
    }

    fun setToolbarTitle(title: String) {
        findViewById<MaterialToolbar>(R.id.toolbar).title = title
    }
}