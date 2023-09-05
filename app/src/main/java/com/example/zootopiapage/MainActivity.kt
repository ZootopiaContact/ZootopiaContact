package com.example.zootopiapage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zootopiapage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ContactListFragment(), "연락처")
        adapter.addFragment(mypage(), "마이페이지")

        binding.viewpager.adapter = adapter
        binding.tablayout.setupWithViewPager(binding.viewpager)
    }
}
