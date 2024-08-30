package com.example.jobs_r_us

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JobAdapter(private val jobs: List<JobItem>) : RecyclerView.Adapter<JobAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobImage: ImageView = itemView.findViewById(R.id.jobImage)
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val job = jobs[position]
                    val context = itemView.context
                    val intent = Intent(context, JobDescriptionActivity::class.java)
                    intent.putExtra("JOB_TITLE", job.title)
                    intent.putExtra("JOB_DESCRIPTION", "Description for ${job.title}") // Update this as needed
                    intent.putExtra("JOB_IMAGE_RES_ID", job.imageResId)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = jobs[position]
        holder.jobImage.setImageResource(job.imageResId)
        holder.jobTitle.text = job.title
    }

    override fun getItemCount() = jobs.size
}
