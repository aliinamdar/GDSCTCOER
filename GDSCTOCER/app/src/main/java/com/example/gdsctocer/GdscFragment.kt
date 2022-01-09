package com.example.gdsctocer

import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_gdsc2.*
import kotlinx.android.synthetic.main.up_event_card.*
import android.app.NotificationManager as NotificationManager1


class GdscFragment : Fragment() {




    private lateinit var eventArrayList : ArrayList<EventModel>
    private lateinit var myEventAdapter: EventAdapter
    private lateinit var db : FirebaseFirestore

    val CHANNEL_ID = "GDSCTCOERID"
    val CHANNEL_NAME = "GDSCTCOER"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gdsc2, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rc_event_up.layoutManager = LinearLayoutManager(context)
        rc_event_up.setHasFixedSize(true)

        eventArrayList = arrayListOf()

        myEventAdapter = EventAdapter(eventArrayList, this)



        rc_event_up.adapter = myEventAdapter

        myEventAdapter.setOnItemClickListener(object : EventAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val ed = Intent(context, event_detail::class.java)
                ed.putExtra("Title", eventArrayList[position].EventTitle)
                ed.putExtra("Description", eventArrayList[position].EventDescription)
                ed.putExtra("Date", eventArrayList[position].EventDateTime)
                ed.putExtra("RSVPLink", eventArrayList[position].EventLink)
                ed.putExtra("Image", eventArrayList[position].EventImage)
                ed.putExtra("ButtonName", eventArrayList[position].EventButtonName)
                startActivity(ed)


            }


        })


        eventChangeListener()
        createNotifiChannel()







    }



    private fun eventChangeListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("events")
            .addSnapshotListener(object : EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {



                        if (error != null){
                            Log.e("Firestore Error",error.message.toString())
                            return
                        }



                        for (dc : DocumentChange in value?.documentChanges!!){

                            if (dc.type == DocumentChange.Type.ADDED) {

                                eventArrayList.add(dc.document.toObject(EventModel::class.java))
                                val i = Intent(context,MainActivity::class.java)
                                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                val pendingIntent = PendingIntent.getActivity(context,0,i,0)

                                val builder : NotificationCompat.Builder = NotificationCompat.Builder(requireContext(),"GDSCTCOERID")
                                    .setSmallIcon(R.drawable.ic_gdsc)
                                    .setContentTitle("Google Developer Student Club TCOER")
                                    .setContentText("New Event Added!!!")
                                    .setAutoCancel(true)
                                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                                    .setContentIntent(pendingIntent)
                                val  notificationManager = NotificationManagerCompat.from(requireContext())
                                notificationManager.notify(2714,builder.build())



                            }else{

                            }


                        }




                        myEventAdapter.notifyDataSetChanged()



                    }

                })


    }

    private fun createNotifiChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           val channel = NotificationChannel("GDSCTCOERID","GDSCTCOER",
           NotificationManager1.IMPORTANCE_HIGH).apply {
               lightColor = Color.GREEN
               enableLights(true)
           }
            val notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
            notificationManager.createNotificationChannel(channel)


        }


    }

    companion object {

    }



}