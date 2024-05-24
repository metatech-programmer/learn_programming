package com.metatech.pstudy

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class VideoActivity : AppCompatActivity() {

    private val name by lazy { intent.getStringExtra("name") }
    private lateinit var webView: WebView
    private lateinit var btnBack: CardView
    private val youtubeVideoIds = mapOf(
        "java" to "W86KTBSiX2o",
        "python" to "nKPbfIU442g",
        "javascript" to "z95mZVUcJ-E",
        "c++" to "VQo6gj7-hw8",
        "c#" to "L-f8u0hwi4Y",
        "php" to "BcGAPkjt_IE",
        "html" to "ELSm-G201Ls",
        "css" to "hrxjBqZWsb0",
        "android" to "vJapzH_46a8",
        "swift" to "kpsVJptSv1U"
    )
    private val youtubeBaseUrl = "https://www.youtube.com/watch?v="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        webView = findViewById(R.id.webView)
        btnBack = findViewById(R.id.cvBack)

        val language = intent.getStringExtra("language") ?: "java" // valor predeterminado "java"
        val youtubeVideoId = youtubeVideoIds[language] ?: youtubeVideoIds.values.first()
        intent.putExtra("name", name)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val videoUrl = "$youtubeBaseUrl$youtubeVideoId"
        webView.loadUrl(videoUrl)

        btnBack.setOnClickListener {
            intent.putExtra("name", name)
            finish()
        }
    }
}
