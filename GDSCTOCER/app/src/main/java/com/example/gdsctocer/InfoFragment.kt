package com.example.gdsctocer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_info2.*


class InfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info2, container, false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_instagram.setOnClickListener {
            val instaURL = Intent(Intent.ACTION_VIEW)
            instaURL.data = Uri.parse("https://www.instagram.com/dsc_tcoer/")
            startActivity(instaURL)
        }
        btn_linkedin.setOnClickListener {
            val linkedinURL = Intent(Intent.ACTION_VIEW)
            linkedinURL.data = Uri.parse("https://www.linkedin.com/company/google-developer-student-club-tcoer//")
            startActivity(linkedinURL)
        }
        btn_whatsapp.setOnClickListener {
            val whatsappURL = Intent(Intent.ACTION_VIEW)
            whatsappURL.data = Uri.parse("https://chat.whatsapp.com/HUuT6QWO8gf3myJ1zEoIT1")
            startActivity(whatsappURL)
        }
        btn_discord.setOnClickListener {
            val discordURL = Intent(Intent.ACTION_VIEW)
            discordURL.data = Uri.parse("https://discord.com/invite/X7JXPG8Tmt")
            startActivity(discordURL)
        }
        btn_gmail.setOnClickListener {
            val gmailURL = Intent(Intent.ACTION_VIEW)
            gmailURL.data = Uri.parse("mailto:dsctcoer21@gmail.com")
            startActivity(gmailURL)
        }
        btn_website.setOnClickListener {
            val websiteURL = Intent(Intent.ACTION_VIEW)
            websiteURL.data = Uri.parse("https://linktr.ee/dsc_tcoer")
            startActivity(websiteURL)
        }
        btn_bm.setOnClickListener {
            val bmURL = Intent(Intent.ACTION_VIEW)
            bmURL.data = Uri.parse("https://gdsc.community.dev/trinity-college-of-engineering-and-research-pune/")
            startActivity(bmURL)
        }
        val  arrayListsession = ArrayList<Datasession>()

        arrayListsession.add(Datasession("Solution Challenge",R.drawable.solution))
        arrayListsession.add(Datasession("Hands-on Workshops",R.drawable.workshop))
        arrayListsession.add(Datasession("Webinar",R.drawable.webinar))
        arrayListsession.add(Datasession("Study Jams",R.drawable.study))
        arrayListsession.add(Datasession("Explore Machine Learning",R.drawable.brain))
        arrayListsession.add(Datasession("Roadmap Sessions",R.drawable.roadmap))
        arrayListsession.add(Datasession("Expert Tech Talks",R.drawable.podcast))

        val sessionAdapter = SessionAdapter(arrayListsession, this)
        rc_event.layoutManager = LinearLayoutManager(context)
        rc_event.adapter = sessionAdapter







    }



}