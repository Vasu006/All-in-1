package com.example.allin1.UI.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allin1.domain.businessLogic.MainViewModel
import com.example.allin1.R
import com.example.allin1.domain.businessLogic.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

val mainviewmodel = MainViewModel()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewpager.adapter = ViewPagerAdapter(supportFragmentManager)

        main_tab_layout.setupWithViewPager(main_viewpager)
    }
}