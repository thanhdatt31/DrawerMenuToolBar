package com.example.drawermenutoolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.drawermenutoolbar.fragment.HomeFragment
import com.example.drawermenutoolbar.fragment.PhotoFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        displayScreen(0)
        supportFragmentManager.beginTransaction()
            .replace(R.id.relativelayout, HomeFragment()).commit()
    }

    private fun displayScreen(i: Int) {
        when (i) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.relativelayout, HomeFragment()).commit()
            }
            R.id.nav_photos -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.relativelayout, PhotoFragment()).commit()
            }
            R.id.nav_aboutUs -> {
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_rateMe -> {
                Toast.makeText(this, "Rate Me 5 Star", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> {
                Toast.makeText(this@MainActivity, "Add", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
            }
            R.id.person -> {
                Toast.makeText(this, "Person", Toast.LENGTH_SHORT).show()

            }
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}