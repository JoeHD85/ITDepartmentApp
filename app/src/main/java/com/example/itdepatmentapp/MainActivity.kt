package com.example.itdepatmentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var emailFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        emailFab = findViewById(R.id.emailFab)

        val menuItems = arrayOf("Faculty/Staff Directory", "Courses", "Admissions", "Social Media")
        val adapter = ArrayAdapter(this, R.layout.menu_item, R.id.menuText, menuItems)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, FacultyDirectoryActivity::class.java))
                1 -> startActivity(Intent(this, CoursesActivity::class.java))
                2 -> startActivity(Intent(this, AdmissionsActivity::class.java))
                3 -> startActivity(Intent(this, SocialMediaActivity::class.java))
            }
        }

        emailFab.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "hod@ucc.edu", null))
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
    }
}
