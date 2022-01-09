package com.example.gdsctocer

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.session_cardview.view.*
import kotlinx.android.synthetic.main.session_cardview.view.tv_title_session
import kotlinx.android.synthetic.main.up_event_card.view.*
import java.net.URL

class EventAdapter(val eventArrayList: ArrayList<EventModel>, val context: GdscFragment) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

       val eventTitle:TextView = itemView.findViewById(R.id.event_title)
        val eventDescription:TextView = itemView.findViewById(R.id.event_description)
        val eventDate:TextView = itemView.findViewById(R.id.event_date)
        val eventImage:ImageView = itemView.findViewById(R.id.event_image)
        val btnEventLink : Button = itemView.findViewById(R.id.btn_RSVP_Link)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.up_event_card,parent,false)

        return ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventArrayList[position]
        holder.eventTitle.text = event.EventTitle
        holder.eventDescription.text = event.EventDescription
        holder.eventDate.text = event.EventDateTime
        holder.btnEventLink.text = event.EventButtonName
        holder.btnEventLink.setOnClickListener {
            val eventLink = Intent(Intent.ACTION_VIEW)
            eventLink.data = Uri.parse(event.EventLink)
            context.startActivity(eventLink)
        }



        Glide.with(context)
            .load(event.EventImage)
            .into(holder.eventImage)

    }

    override fun getItemCount(): Int {
        return eventArrayList.size
    }

}


