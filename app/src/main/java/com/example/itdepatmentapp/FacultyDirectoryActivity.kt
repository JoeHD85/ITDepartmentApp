package com.example.itdepatmentapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class FacultyDirectoryActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var facultyAdapter: FacultyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_directory)

        listView = findViewById(R.id.listView)

        val facultyList = listOf(
            Faculty("Ms. Natalie Rose", "ithod@ucc.edu.jm", "(876)906-4046", R.drawable.placeholder_image),
            Faculty("Henry Osborn", "hosbourne@ucc.edu.jm", "(876)000-0000", R.drawable.placeholder_image),
            Faculty("Otis Osborn", "itfaculty@ucc.edu.jm", "(876)218-2935", R.drawable.placeholder_image),
            Faculty("Stefan Watson", "swatson@faculty.ucc.edu.jm", "(876)000-0000", R.drawable.placeholder_image),
            Faculty("Cecil White", "cwhite01@faculty.ucc.edu.jm", "(876)428-3911", R.drawable.placeholder_image),
            Faculty("Neil Williams", "itlecturer@ucc.edu.jm", "(876)906-4069", R.drawable.placeholder_image),
            Faculty("Pamella Reid", "itprogrammeofficer2@ucc.edu.jm ", "(876)906-4020", R.drawable.placeholder_image),
        )

        facultyAdapter = FacultyAdapter(this, facultyList)
        listView.adapter = facultyAdapter
    }
}