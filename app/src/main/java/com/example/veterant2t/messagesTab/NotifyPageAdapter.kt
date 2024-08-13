package com.example.veterant2t.messagesTab
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class NotifPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PriorityFragment()
            1 ->
            2 -> TabFragment3()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}