package com.example.itdepatmentapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var socialMediaSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        socialMediaSpinner = findViewById(R.id.socialMediaSpinner)

        val socialMediaUrls = listOf(
            "https://www.facebook.com/uccjamaica",
            "https://www.twitter.com/uccjamaica",
            "https://www.instagram.com/uccjamaica"
        )

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.social_media_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        socialMediaSpinner.adapter = adapter

        socialMediaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                webView.loadUrl(socialMediaUrls[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
