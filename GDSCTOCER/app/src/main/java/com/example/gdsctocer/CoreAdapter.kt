package com.example.gdsctocer

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CoreAdapter(val coreArrayList: ArrayList<CoreModel>, val context: CommunityFragment) : RecyclerView.Adapter<CoreAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coreTitle : TextView = itemView.findViewById(R.id.core_title)
        val coreDescription : TextView = itemView.findViewById(R.id.core_Desc)
        val coreProfile : ImageView = itemView.findViewById(R.id.iv_core)
        val btnLinkedin : ImageButton = itemView.findViewById(R.id.core_linkedin)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.core_card,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val core = coreArrayList[position]
        holder.coreTitle.text = core.CoreTitle
        holder.coreDescription.text = core.CoreDescription
        holder.coreProfile.setImageResource(core.CoreImage)
        holder.btnLinkedin.setOnClickListener {
            val coreLink = Intent(Intent.ACTION_VIEW)
            coreLink.data = Uri.parse(core.btnLinkedin)
            context.startActivity(coreLink)
        }



    }

    override fun getItemCount(): Int {
        return coreArrayList.size
    }

}