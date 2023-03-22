package com.example.wordgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class GamePlay : AppCompatActivity() {

    val randomWrdLst = arrayListOf("apple","banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "indigo", "jujube")
    val ChosenWrd =  arrayListOf<String>()
    var Chances=10;
    var lstWrds=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)
        val titleTxt= findViewById<TextView>(R.id.Title)
        val guessedWord = findViewById<TextView>(R.id.WordGuessed)
        val inputWord = findViewById<EditText>(R.id.WordInput)
        val enterBtn = findViewById<Button>(R.id.entrBtn)
        val numberTries = findViewById<TextView>(R.id.UsersTries)
        val ListButton = findViewById<Button>(R.id.button)
        numberTries.text= "Tries Left: " + Chances
        dashesOutput(guessedWord)
        pressButton(enterBtn,inputWord,lstWrds.toList(),guessedWord,numberTries)
        welcomeHeader(titleTxt)

        ListButton.setOnClickListener()
        {
            val intent = Intent(this, WordDetails::class.java)
            startActivity(intent)
        }


    }

    fun welcomeHeader(titleTxt:TextView)
    {
        val myValue = intent.getStringExtra("nameTxt")
        titleTxt.text="Lets Dala "+ myValue
    }
//
    fun dashesOutput(guessedWord:TextView)
    {
        var random = (0..3).random()
        lstWrds = randomWrdLst[random]
        ChosenWrd.clear()
        //guessedWord.text=null
        for(char in lstWrds)
        {
            ChosenWrd.add("_")
        }
        guessedWord.text=ChosenWrd.joinToString().replace(",","")
    }

    fun pressButton(enterBtn:Button,inputWord:EditText,lstWrd:List<Char>,guessedWord:TextView,numberTries:TextView)
    {

        enterBtn.setOnClickListener()
        {
                var char = inputWord.text.single()
                if (lstWrds.contains(char)) {
                    for (i in lstWrd.indices) {
                        if (lstWrds.get(i) == char) {
                            ChosenWrd.set(i, char.toString())
                            guessedWord.text=ChosenWrd.joinToString().replace(",","")
                        }
                    }
                }
                else
                {
                    Chances--
                    Toast.makeText(this,"Nah Dawg, you wrong", Toast.LENGTH_LONG).show();
                    numberTries.text= "Tries Left: " + Chances
                }

                if(Chances==0)
                {
                 Toast.makeText(this,"You took the L", Toast.LENGTH_LONG).show();
                    Chances=10
                    dashesOutput(guessedWord)
                    numberTries.text= "Tries Left: " + Chances
                }
                if(!guessedWord.text.contains("_"))
                {
                 Toast.makeText(this,"you caught the dub", Toast.LENGTH_LONG).show();
                    Chances=10
                    dashesOutput(guessedWord)
                    numberTries.text= "Tries Left: " + Chances
                }
           //inputWord.text=null
        }
    }
}


