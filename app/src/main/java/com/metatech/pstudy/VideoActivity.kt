package com.metatech.pstudy

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class VideoActivity : AppCompatActivity() {

    private val name by lazy { intent.getStringExtra("name") }
    private lateinit var webView: WebView
    private lateinit var aiview: WebView
    private lateinit var btnBack: CardView
    private val youtubeVideoIds = mapOf(
        "java" to "W86KTBSiX2o",
        "python" to "nKPbfIU442g",
        "javascript" to "Z34BF9PCfYg&t=3051s",
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
        aiview = findViewById(R.id.webViewia)
        btnBack = findViewById(R.id.cvBack)

        val language = intent.getStringExtra("language") ?: "java" // valor predeterminado "java"
        val youtubeVideoId = youtubeVideoIds[language] ?: youtubeVideoIds.values.first()
        intent.putExtra("name", name)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val videoUrl = "$youtubeBaseUrl$youtubeVideoId"
        webView.loadUrl(videoUrl)

        aiview.settings.javaScriptEnabled = true
        aiview.webViewClient = WebViewClient()
        val aiUrl = "https://stack-ai.com/public_form/69882583-442f-4e74-aa15-fbae89792751/3b0005fd-cbe6-4d4a-99ff-89cc529f9c94/66514ebb95724e088a194de6"
        aiview.loadUrl(aiUrl)


        btnBack.setOnClickListener {
            intent.putExtra("name", name)
            finish()
        }





    }

}
