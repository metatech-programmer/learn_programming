package com.metatech.pstudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CursosActivity : AppCompatActivity() {

    private lateinit var btnJava: ImageButton
    private lateinit var btnJs: ImageButton
    private lateinit var btnPython: ImageButton
    private lateinit var btnHtml: ImageButton
    private lateinit var btnCpp: ImageButton
    private lateinit var btnCsharp: ImageButton
    private lateinit var btnAndroid: ImageButton
    private lateinit var btnPhp: ImageButton
    private lateinit var btnSwift: ImageButton
    private lateinit var btnCss: ImageButton

    private val name by lazy { intent.getStringExtra("name") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        btnJava = findViewById(R.id.btn_java)
        btnJs = findViewById(R.id.btn_js)
        btnPython = findViewById(R.id.btn_python)
        btnHtml = findViewById(R.id.btn_html)
        btnCpp = findViewById(R.id.btn_cplusplus)
        btnCsharp = findViewById(R.id.btn_ccharp)
        btnAndroid = findViewById(R.id.btn_android)
        btnPhp = findViewById(R.id.btn_php)
        btnSwift = findViewById(R.id.btn_swift)
        btnCss = findViewById(R.id.btn_css)

        btnJava.setOnClickListener { onStartLearningClicked( "java") }
        btnJs.setOnClickListener { onStartLearningClicked("javascript") }
        btnPython.setOnClickListener { onStartLearningClicked( "python") }
        btnHtml.setOnClickListener { onStartLearningClicked( "html") }
        btnCss.setOnClickListener { onStartLearningClicked( "css") }
        btnCpp.setOnClickListener { onStartLearningClicked( "c++") }
        btnCsharp.setOnClickListener { onStartLearningClicked( "c#") }
        btnAndroid.setOnClickListener { onStartLearningClicked( "android") }
        btnPhp.setOnClickListener { onStartLearningClicked( "php") }
        btnSwift.setOnClickListener { onStartLearningClicked( "swift") }


    }
    private fun onStartLearningClicked( lang: String) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("language", lang)
        intent.putExtra("name", name)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_cursos, menu)
        return true
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


