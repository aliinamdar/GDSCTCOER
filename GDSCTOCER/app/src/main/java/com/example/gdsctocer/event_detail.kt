package com.example.gdsctocer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class event_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val titleEvent : TextView = findViewById(R.id.tv_details)
        val descriptionEvent : TextView = findViewById(R.id.tv_des)
        val dateEvent : TextView = findViewById(R.id.tv_time)
        val imageEvent : ImageView = findViewById(R.id.iv_details)
        val btnEvent : Button = findViewById(R.id.btn_details)

        val bundle : Bundle?= intent.extras

        val title = bundle!!.getString("Title")
        val description = bundle.getString("Description")
        val date = bundle.getString("Date")
        val link = bundle.getString("RSVPLink")
        val image = bundle.getString("Image")
        val buttonName = bundle.getString("ButtonName")

        titleEvent.text = title
        descriptionEvent.text = description
        dateEvent.text = date
        btnEvent.text = buttonName

        btnEvent.setOnClickListener {
             val be = Intent(Intent.ACTION_VIEW)
            be.data = Uri.parse(link)
            this.startActivity(be)
        }


        Glide.with(this)
            .load(image)
            .into(imageEvent)


    }
}