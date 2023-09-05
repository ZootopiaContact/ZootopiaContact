package com.example.zootopiapage

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.zootopiapage.databinding.ActivityMainBinding
import com.example.zootopiapage.databinding.DialogAddItemBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter(supportFragmentManager)

        adapter.addFragment(contact(), "연락처")
        adapter.addFragment(mypage(), "마이페이지")

        binding.viewpager.adapter = adapter
        binding.tablayout.setupWithViewPager(binding.viewpager)

        binding.addListBtn.setOnClickListener{
            addItemDialog()
        }
    }
    fun  addItemDialog() {
        val dialogBinding = DialogAddItemBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(this)
            .setTitle("연락처 추가")
            .setView(dialogBinding.root)
            .setPositiveButton("추가") {_,_ ->
                val name = dialogBinding.nameDialogEdit.text.toString()
                val phone = dialogBinding.phoneDialogEdit.text.toString()
                val email = dialogBinding.emailDialogEdit.text.toString()

                val addItem = ZootopiaInfo()



            }
    }
}
