package com.example.jobs_r_us

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JobDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_description)

        // Get references to UI elements
        val jobImageView: ImageView = findViewById(R.id.jobImageView)
        val jobTitleTextView: TextView = findViewById(R.id.jobTitleTextView)
        val jobDescriptionTextView: TextView = findViewById(R.id.jobDescriptionTextView)

        // Retrieve data from the Intent
        val jobTitle = intent.getStringExtra("JOB_TITLE") ?: "No Title"
        val jobDescription = intent.getStringExtra("JOB_DESCRIPTION") ?: "No Description"
        val jobImageResId = intent.getIntExtra("JOB_IMAGE_RES_ID", R.drawable.ic_launcher_background)

        // Set the data to the UI elements
        jobTitleTextView.text = jobTitle
        jobDescriptionTextView.text = jobDescription
        jobImageView.setImageResource(jobImageResId)
    }
}
