package com.example.gdsctocer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    setupActionBarWithNavController(findNavController(R.id.frag_container))

        val infoFragment = InfoFragment()
        val gdscFragment = GdscFragment()
        val communityFragment = CommunityFragment()

        setCurrentFragment(gdscFragment)

        bottom_nav.selectedItemId=R.id.nav_gdsc

        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)



        BottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.nav_info->setCurrentFragment(infoFragment)
                R.id.nav_gdsc->setCurrentFragment(gdscFragment)
                R.id.nav_community->setCurrentFragment(communityFragment)

            }
            true
        }


    }



    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_container,fragment)
            commit()
        }
}