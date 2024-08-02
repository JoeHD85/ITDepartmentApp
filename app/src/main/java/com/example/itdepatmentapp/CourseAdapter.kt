package com.example.itdepatmentapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CourseAdapter(private val context: Context, private var dataSource: List<Course>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    fun updateData(newData: List<Course>) {
        dataSource = newData
        notifyDataSetChanged()
    }

    override fun getCount(): Int = dataSource.size

    override fun getItem(position: Int): Any = dataSource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.course_item, parent, false)

        val codeTextView = view.findViewById<TextView>(R.id.courseCode)
        val nameTextView = view.findViewById<TextView>(R.id.courseName)
        val creditsTextView = view.findViewById<TextView>(R.id.courseCredits)
        val prerequisitesTextView = view.findViewById<TextView>(R.id.coursePrerequisites)
        val descriptionTextView = view.findViewById<TextView>(R.id.courseDescription)

        val course = getItem(position) as Course

        codeTextView.text = course.code
        nameTextView.text = course.name
        creditsTextView.text = course.credits.toString()
        prerequisitesTextView.text = course.prerequisites
        descriptionTextView.text = course.description

        return view
    }
}
