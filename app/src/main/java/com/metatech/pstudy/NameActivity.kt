package com.metatech.pstudy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

   private lateinit var btnSesion: Button
   private lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        btnSesion = findViewById(R.id.btnSesion)
        etName = findViewById(R.id.etName)

       btnSesion.setOnClickListener {
           // Iniciar la siguiente actividad
           val intent = Intent(this, CursosActivity::class.java)
           intent.putExtra("name", etName.text.toString())
           startActivity(intent)
       }
    }

    fun onStartLearningClicked() {
        // Iniciar la siguiente actividad
        val intent = Intent(this, CursosActivity::class.java)
        startActivity(intent)
    }
}