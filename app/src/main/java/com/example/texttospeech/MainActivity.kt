package com.example.texttospeech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*




class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var etText : EditText
    lateinit var btSpeak : Button
    lateinit var tts : TextToSpeech





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etText = findViewById(R.id.etText)
        btSpeak =findViewById(R.id.btSpeak)
        btSpeak.isEnabled = false
        tts = TextToSpeech(this,  this)
        btSpeak.setOnClickListener{
            val text = etText.text.toString()
            tts.speak(text,TextToSpeech.QUEUE_FLUSH, null,"")

        }

    }
    override fun onInit(status: Int){
        if(status == TextToSpeech.SUCCESS){
            var result = tts.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

            }
            else{
                btSpeak.isEnabled = true
            }
        }
    }
}