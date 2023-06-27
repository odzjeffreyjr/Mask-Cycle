package com.example.mask_cycle

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import com.example.mask_cycle.databinding.ActivityMainBinding
import com.example.mask_cycle.ui.leaderboard.LeaderboardFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_leaderboard, R.id.nav_connect
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val fromOther = intent.getIntExtra("login",0 )

        val infoButton = findViewById<FloatingActionButton>(R.id.infoButton)
        infoButton.setOnClickListener{
            startActivity(Intent(this, InfoActivity::class.java))
        }

        val teamButton = findViewById<FloatingActionButton>(R.id.teamButton)
        teamButton.setOnClickListener{
            startActivity(Intent(this, TeamActivity::class.java))
        }

        val leaderboardButton = findViewById<FloatingActionButton>(R.id.leaderboardButton)
        leaderboardButton.setOnClickListener{
            navController.navigate(R.id.action_nav_home_to_nav_leaderboard)
        }

        val clMap = findViewById<ConstraintLayout>(R.id.clMap)

        val refreshButton = findViewById<FloatingActionButton>(R.id.refreshButton)
        refreshButton.setOnClickListener{
            clMap.setBackgroundResource(R.drawable.emptymap)
        }

        val cvMask = findViewById<CardView>(R.id.cvMask)
        cvMask.setOnClickListener{
           clMap.setBackgroundResource(R.drawable.bluemap)
        }

        val joinCompetition = findViewById<Button>(R.id.joinCompetition)
        joinCompetition.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }

        val cvTest = findViewById<CardView>(R.id.cvTest)
        cvTest.setOnClickListener{
            clMap.setBackgroundResource(R.drawable.yellowmap)
        }

        if (fromOther == 1){
            Toast.makeText(this, "You are now logged in", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.account -> {
                startActivity(Intent(this, Login::class.java))
                true
            }
            else -> false
        }
    }
}