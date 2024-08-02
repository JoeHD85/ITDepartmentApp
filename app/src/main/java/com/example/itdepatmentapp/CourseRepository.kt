package com.example.itdepatmentapp

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class CourseRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getCourses(callback: (List<Course>) -> Unit) {
        db.collection("courses")
            .get()
            .addOnSuccessListener { result: QuerySnapshot ->
                val courses = result.map { document ->
                    document.toObject(Course::class.java)
                }
                callback(courses)
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error getting documents: ", exception)
            }
    }

    fun addCourse(course: Course) {
        db.collection("courses")
            .add(course)
            .addOnSuccessListener { documentReference ->
                Log.d("Firestore", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error adding document", e)
            }
    }
}
