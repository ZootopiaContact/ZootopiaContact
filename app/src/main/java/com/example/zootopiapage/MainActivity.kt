package com.example.zootopiapage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.example.zootopiapage.databinding.ActivityMainBinding
import com.example.zootopiapage.databinding.DialogAddItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()

        binding.addListBtn.setOnClickListener {
            addItemDialog()
        }


    }

    private fun initViewPager() {

        var viewPager2Adatper = ViewPager2Adapter(this)
        viewPager2Adatper.addFragment(ContactListFragment())
        viewPager2Adatper.addFragment(MypageFragment())

        binding.viewpager.apply {
            adapter = viewPager2Adatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "Tab1"
                1 -> tab.text = "Tab2"
                2 -> tab.text = "Tab3"
            }
        }.attach()
    }

    fun addItemDialog() {
        val dialogBinding = DialogAddItemBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(this)
            .setTitle("연락처 추가")
            .setView(dialogBinding.root)
            .setPositiveButton("추가") { _, _ ->
                val name = dialogBinding.nameDialogEdit.text.toString()
                val call = dialogBinding.phoneDialogEdit.text.toString()
                val email = dialogBinding.emailDialogEdit.text.toString()

                val addItem = ZootopiaInfo(R.drawable.apple, name, call, email)

                val contactListFragment =
                    (binding.viewpager.adapter as ViewPager2Adapter).getFragment(binding.viewpager.currentItem)
                if (contactListFragment is ContactListFragment) {
                    contactListFragment.addItem(addItem)
                }
            }
            .setNegativeButton("취소", null)
            .create()

        dialog.show()
    }
}
