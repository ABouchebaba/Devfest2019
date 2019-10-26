package com.example.devfest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.devfest.ui.frgs.AdvicesFragment
import com.example.devfest.ui.frgs.MapFragment
import com.example.devfest.ui.frgs.PrefrencesFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AdvicesFragment()
            1 -> MapFragment()
            2 -> PrefrencesFragment()
           else -> null
        }!!
    }

    override fun getCount(): Int = 3

}