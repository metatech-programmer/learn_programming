package com.metatech.pstudy

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
    private val nombreRecuperado = intent.getStringExtra("name")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        tvName = findViewById(R.id.username)
        imagen = findViewById(R.id.imagen)
        btnBack = findViewById(R.id.btn_back)
        btnLogout = findViewById(R.id.btn_logout)

        tvName.text = nombreRecuperado
        val uri = "https://ui-avatars.com/api/?name=$nombreRecuperado"
        Glide.with(this)
                    .load(uri)
                   .into(imagen)

        btnBack.setOnClickListener {
         super.onBackPressedDispatcher.onBackPressed()
        }

        btnLogout.setOnClickListener {
            finish()
        }

    }
}
