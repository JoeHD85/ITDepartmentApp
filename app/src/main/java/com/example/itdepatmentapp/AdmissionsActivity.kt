package com.example.itdepatmentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity() {

    private lateinit var applyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        applyButton = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            val applyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ucc.edu.jm/apply"))
            startActivity(applyIntent)
        }
    }
}
