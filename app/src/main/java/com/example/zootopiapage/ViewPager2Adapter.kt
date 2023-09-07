package com.example.zootopiapage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments: MutableList<Fragment> = mutableListOf()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }

    // 추가: 프래그먼트 액세스를 위한 메서드
    fun getFragment(position: Int): Fragment? {
        if (position in 0 until fragments.size) {
            return fragments[position]
        }
        return null
    }
}


