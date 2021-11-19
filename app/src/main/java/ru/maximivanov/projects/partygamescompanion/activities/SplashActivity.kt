package ru.maximivanov.projects.partygamescompanion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.maximivanov.projects.partygamescompanion.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this@SplashActivity, StartGameActivity::class.java)
        startActivity(intent)
        finish()
    }
}