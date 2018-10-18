package com.circlenode.el_learning.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.circlenode.el_learning.fragments.KelasDelapanFragment
import com.circlenode.el_learning.fragments.KelasSembilanFragment
import com.circlenode.el_learning.fragments.KelasTujuhFragment

class KelasPagerAdapter (fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){


    private val pages = listOf(
            KelasTujuhFragment(),
            KelasDelapanFragment(),
            KelasSembilanFragment()
    )
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Kelas 7"
            1 -> "Kelas 8"
            else -> "Kelas 9"
        }
    }
}