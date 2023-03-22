package com.example.wordgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text

class StartGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
        val startBtn = findViewById<Button>(R.id.StartBtn)
        val nameTxt = findViewById<EditText>(R.id.NameTxtBx)
        val intent = Intent(this, GamePlay::class.java)

        startBtn.setOnClickListener()
        {
            intent.putExtra("nameTxt",nameTxt.text.toString())
            startActivity(intent)
        }
    }
}