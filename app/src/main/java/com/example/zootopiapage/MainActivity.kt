package com.example.zootopiapage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zootopiapage.databinding.ActivityMainBinding
import com.example.zootopiapage.databinding.DialogAddItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2Adapter: ViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addFragment(ContactListFragment.newInstance("param1", "param2"))
        viewPager2Adapter.addFragment(MypageFragment())
        viewPager2Adapter.addFragment(ContactDetailFragment())

        initViewPager()

        binding.addListBtn.setOnClickListener {
            val contactListFragment = viewPager2Adapter.getFragment(0) as? ContactListFragment
            contactListFragment?.addItemDialog()
        }
    }

    private fun initViewPager() {
        binding.viewpager.apply {
            adapter = viewPager2Adapter
        }
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "연락처"
                1 -> tab.text = "마이 페이지"
            }
        }.attach()
    }

    // RecyclerView 아이템 클릭 이벤트 처리를 MainActivity에서 수행
    fun onRecyclerViewItemClick(position: Int, contactData: ZootopiaInfo) {
        val fragmentB = viewPager2Adapter.getFragment(2) as? ContactDetailFragment
        if (fragmentB != null) {
            val bundle = Bundle()
            bundle.putParcelable("contactData", contactData)
            fragmentB.arguments = bundle
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentB ?: ContactDetailFragment())
            .addToBackStack(null)
            .commit()
    }
}
