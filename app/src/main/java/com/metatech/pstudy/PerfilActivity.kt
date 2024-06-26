package com.metatech.pstudy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class PerfilActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var btnBack: ImageButton
    private lateinit var imagen: AppCompatImageView
    private lateinit var btnLogout: AppCompatButton
    private lateinit var tvLevel: TextView

    private val nombreRecuperado by lazy { intent.getStringExtra("name") }
    private val level by lazy { intent.getStringExtra("level") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        tvName = findViewById(R.id.username)
        imagen = findViewById(R.id.imagen)
        btnBack = findViewById(R.id.btn_back)
        btnLogout = findViewById(R.id.btn_logout)
        tvLevel = findViewById(R.id.nivel)

        tvLevel.text = level

        tvName.text = nombreRecuperado
        val uri = "https://ui-avatars.com/api/?name=$nombreRecuperado&size=500"

        Glide.with(this)
                    .load(uri)
                   .into(imagen)


        btnBack.setOnClickListener {
            intent.putExtra("name", nombreRecuperado)
         super.onBackPressedDispatcher.onBackPressed()

        }

        btnLogout.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }

    }
}
