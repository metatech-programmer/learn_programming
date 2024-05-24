package com.metatech.pstudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_cursos, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> navigateToScreens(PerfilActivity::class.java)
            R.id.action_principiante -> navigateToScreens(CursosPrincipianteActivity::class.java)
            R.id.action_intermedio -> navigateToScreens(CursosIntermedioActivity::class.java)
            R.id.action_avanzado -> navigateToScreens(CursosAvanzadoActivity::class.java)
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToScreens(screenForward: Class<*>): Boolean {
        val intent = Intent(this, screenForward)
        startActivity(intent)
        return true
    }

}
