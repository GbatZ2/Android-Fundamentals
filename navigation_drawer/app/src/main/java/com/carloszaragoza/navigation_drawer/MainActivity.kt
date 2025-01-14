package com.carloszaragoza.navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dwLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val nView = findViewById<NavigationView>(R.id.navView)
        toggle = ActionBarDrawerToggle(this, dwLayout, R.string.open, R.string.close)
        dwLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(applicationContext, "Item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(applicationContext, "Item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> Toast.makeText(applicationContext, "Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){ return true }
        return super.onOptionsItemSelected(item)
    }
}