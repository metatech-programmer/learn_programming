package com.metatech.pstudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.timer

class MainActivity: AppCompatActivity() {

private lateinit var btnSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSesion = findViewById(R.id.btnSesion)

        btnSesion.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
           
                startActivity(intent)

        }

    }





}
