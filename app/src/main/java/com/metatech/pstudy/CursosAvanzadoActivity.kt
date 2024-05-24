package com.metatech.pstudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CursosAvanzadoActivity : AppCompatActivity() {


    private val name by lazy { intent.getStringExtra("name") }
    private lateinit var btnSwift: ImageButton
    private lateinit var btnAndroid: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos_avanzado)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        btnAndroid = findViewById(R.id.btn_android)
        btnSwift = findViewById(R.id.btn_swift)

        btnAndroid.setOnClickListener { onStartLearningClicked( "android") }
        btnSwift.setOnClickListener { onStartLearningClicked( "swift") }


    }
    private fun onStartLearningClicked( lang: String) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("language", lang)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_cursos, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cursos -> navigateToScreens(CursosActivity::class.java)
            R.id.action_settings -> navigateToScreens(PerfilActivity::class.java)
            R.id.action_principiante -> navigateToScreens(CursosPrincipianteActivity::class.java)
            R.id.action_intermedio -> navigateToScreens(CursosIntermedioActivity::class.java)
            R.id.action_avanzado -> navigateToScreens(CursosAvanzadoActivity::class.java)
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToScreens(screenForward: Class<*>): Boolean {
        val intent = Intent(this, screenForward)
        intent.putExtra("name", name)
        startActivity(intent)
        return true
    }
}