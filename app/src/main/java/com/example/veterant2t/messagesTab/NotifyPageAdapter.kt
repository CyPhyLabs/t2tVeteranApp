package com.example.veterant2t.messagesTab
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.veterant2t.NotifFragment
import com.example.veterant2t.messagesTab.messageList.CustomAdapter

class NotifPagerAdapter(fragment: Fragment,) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PriorityFragment(NotifFragment.MessageMaster.priorityAdapter)
            1 -> UnreadFragment(NotifFragment.MessageMaster.unreadAdapter)
            2 -> InboxFragment(NotifFragment.MessageMaster.inboxAdapter)
            else -> PriorityFragment(NotifFragment.MessageMaster.priorityAdapter)
        }
    }
}