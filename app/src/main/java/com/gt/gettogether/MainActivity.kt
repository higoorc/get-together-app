package com.gt.gettogether

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.gt.gettogether.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupFirebase()

        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.myNavHostFragment) as NavHostFragment

        navController = navHostFragment.navController

        auth = Firebase.auth

        setupController(navController)
        validateAuthentication()
    }

    private fun setupFirebase() {
        if(BuildConfig.DEBUG) {
            Firebase.database.useEmulator("10.0.2.2", 9000)
            Firebase.auth.useEmulator("10.0.2.2", 9099)
            Firebase.storage.useEmulator("10.0.2.2", 9199)
        }
    }

    private fun validateAuthentication() {
        if (auth.currentUser == null) {
            navController.navigate(R.id.login)
            return
        }
    }

    private fun setupController(navController: NavController) =
        navController.let {
            val appBarConfiguration = configureAppBar()
            setSupportActionBar(binding.toolbar)
            binding.toolbar.setupWithNavController(it, appBarConfiguration)
        }

    private fun configureAppBar(): AppBarConfiguration =
        AppBarConfiguration
            .Builder()
            .setFallbackOnNavigateUpListener {
                onBackPressed()
                true
            }
            .build()

}
