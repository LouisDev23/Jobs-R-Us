package com.example.jobs_r_us

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Find UI elements by their ID
        val profileImageView: ImageView = findViewById(R.id.profileImageView)
        val profileNameTextView: TextView = findViewById(R.id.profileNameTextView)
        val jobRecyclerView: RecyclerView = findViewById(R.id.jobRecyclerView)
        val editProfile: TextView = findViewById(R.id.editProfileTextView)

        // Set up RecyclerView
        jobRecyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data for RecyclerView
        val jobItems = listOf(
            JobItem(R.drawable.ic_launcher_background, "Software Engineer"),
            JobItem(R.drawable.ic_launcher_background, "Product Manager"),
            JobItem(R.drawable.ic_launcher_background, "Designer")
        )
        jobRecyclerView.adapter = JobAdapter(jobItems)

        // Set the profile data programmatically
        profileImageView.setImageResource(R.drawable.ic_launcher_background)
        profileNameTextView.text = "Louis Viljoen"

        // Set up click listener for edit profile
        editProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
