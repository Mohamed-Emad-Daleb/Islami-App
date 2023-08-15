package com.route.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islami.R
import com.route.islami.databinding.ActivityHomeBinding
import com.route.islami.ui.home.taps.hadeth.HadethFragement
import com.route.islami.ui.home.taps.quran.QuranFragement
import com.route.islami.ui.home.taps.radio.RadioFragement
import com.route.islami.ui.home.taps.taspeth.TasbethFragement

class HomeActivity : AppCompatActivity() {
    lateinit var viewBiniding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBiniding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBiniding.root)
        viewBiniding.content.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showTapFragment(QuranFragement())
                }

                R.id.navigation_hadeth -> {
                    showTapFragment(HadethFragement())
                }

                R.id.navigation_sebha -> {
                    showTapFragment(TasbethFragement())
                }

                R.id.navigation_radio -> {
                    showTapFragment(RadioFragement())
                }
            }
            true
        }
        viewBiniding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }

    private fun showTapFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}