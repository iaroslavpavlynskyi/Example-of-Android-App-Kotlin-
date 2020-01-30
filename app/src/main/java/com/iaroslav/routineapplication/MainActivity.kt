package com.iaroslav.routineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnClickCallback {
    override fun onClick(view: View, position: Int) {
        Log.d("tag", position.toString())
        when(position){
            DASHBOARD_CODE -> currentFragment = DashboardFragment()
            WIFI_CODE -> currentFragment = DashboardFragment()
            SETTINGS_CODE -> currentFragment = DashboardFragment()
            SCHOOL_CODE -> currentFragment = DashboardFragment()
            else -> currentFragment = DashboardFragment()
        }
        changeFragment(currentFragment);
    }

    lateinit var currentFragment: Fragment
    lateinit var recyclerView: RecyclerView
    lateinit var items: MutableList<Item>
    lateinit var menuAdapter: MenuAdapter

    // Fragment codes
    val DASHBOARD_CODE: Int = 0
    val WIFI_CODE: Int = 1
    val SETTINGS_CODE: Int = 2
    val SCHOOL_CODE: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dashboardFragment: DashboardFragment = DashboardFragment()

        currentFragment = dashboardFragment

        recyclerView = findViewById(R.id.rv_menu)
        recyclerView.layoutManager = LinearLayoutManager(this)

        items = ArrayList()
        menuAdapter = MenuAdapter(this,items,this)

        items.add(Item(R.drawable.ic_dashboard_black_24dp,DASHBOARD_CODE,"Dashboard Fragment",dashboardFragment))
        items.add(Item(R.drawable.ic_wifi_black_24dp,WIFI_CODE,"WIFI Fragment",dashboardFragment))
        items.add(Item(R.drawable.ic_settings_black_24dp,SETTINGS_CODE,"Settings Fragment",dashboardFragment))
        items.add(Item(R.drawable.ic_school_black_24dp,SCHOOL_CODE,"School Fragment",dashboardFragment))

        recyclerView.adapter = menuAdapter
        changeFragment(dashboardFragment)
    }

    private fun changeFragment(newFragment: Fragment) {
        val fragmentManager: FragmentManager
        val fragmentTransaction: FragmentTransaction

        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()

        // Dashboard instance
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.container,newFragment).commit()

    }
}
