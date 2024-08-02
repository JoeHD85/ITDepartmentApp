package com.example.itdepatmentapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FacultyAdapter(private val context: Context, private val dataSource: List<Faculty>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.faculty_item, parent, false)

        val nameTextView = view.findViewById<TextView>(R.id.facultyName)
        val emailTextView = view.findViewById<TextView>(R.id.facultyEmail)
        val phoneTextView = view.findViewById<TextView>(R.id.facultyPhone)
        val photoImageView = view.findViewById<ImageView>(R.id.facultyPhoto)

        val faculty = getItem(position) as Faculty

        nameTextView.text = faculty.name
        emailTextView.text = faculty.email
        phoneTextView.text = faculty.phone
        photoImageView.setImageResource(faculty.photoResId)

        phoneTextView.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${faculty.phone}"))
            context.startActivity(dialIntent)
        }

        emailTextView.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", faculty.email, null))
            context.startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        return view
    }
}