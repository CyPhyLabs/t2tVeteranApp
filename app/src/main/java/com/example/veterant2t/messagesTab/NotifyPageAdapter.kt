package com.example.veterant2t.messagesTab
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.veterant2t.NotifFragment

class NotifPagerAdapter(fragment: Fragment,) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PriorityFragment(MessageManager.priorityAdapter)
            1 -> UnreadFragment(MessageManager.unreadAdapter)
            2 -> InboxFragment(MessageManager.inboxAdapter)
            else -> PriorityFragment(MessageManager.priorityAdapter)
        }
    }
}