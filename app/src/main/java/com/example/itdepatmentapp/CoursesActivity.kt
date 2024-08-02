package com.example.itdepatmentapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var courseAdapter: CourseAdapter
    private val courseRepository = CourseRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        listView = findViewById(R.id.listView)
        courseAdapter = CourseAdapter(this, emptyList())
        listView.adapter = courseAdapter

        courseRepository.getCourses { courses ->
            courseAdapter.updateData(courses)
        }
    }
}
