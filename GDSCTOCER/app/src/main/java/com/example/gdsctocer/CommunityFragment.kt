package com.example.gdsctocer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_community.*


class CommunityFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coreArrayList = ArrayList<CoreModel>()

        coreArrayList.add(CoreModel("Zahra Dehghan","Community Lead",R.drawable.zahra,"https://www.linkedin.com/in/zahra-dehghan-8ab05b193/"))
        coreArrayList.add(CoreModel("Vedant Bhogawade","Technical Lead",R.drawable.vedant,"https://www.linkedin.com/in/vedantbhogawade-785856193/"))
        coreArrayList.add(CoreModel("Mohammad Anas","Events Lead",R.drawable.anas,"https://www.linkedin.com/in/mohammad-anas-/"))
        coreArrayList.add(CoreModel("Sakshi Sawant","Management Lead",R.drawable.sakski,"https://www.linkedin.com/in/sakshi-shankar-sawant-3772431b3/"))
        coreArrayList.add(CoreModel("Rutuja Shinde","Management Co-Lead",R.drawable.rutuja,"https://www.linkedin.com/in/rutuja-shinde-569652204/"))
        coreArrayList.add(CoreModel("Mohammed Ali Inamdar","Android Lead",R.drawable.ali,"https://www.linkedin.com/in/mohammedaliinamdar"))
        coreArrayList.add(CoreModel("Tanmay Shinde","Web Development Lead",R.drawable.tanmay,"https://www.linkedin.com/in/tanmay-shinde-0670b9192/"))
        coreArrayList.add(CoreModel("Raj Thakur","Creative Lead",R.drawable.raj,"https://www.linkedin.com/in/raj-thakur-2b946a20b/"))

        val coreAdapter = CoreAdapter(coreArrayList,this)
        rc_core.layoutManager = LinearLayoutManager(context)
        rc_core.adapter = coreAdapter

    }

}