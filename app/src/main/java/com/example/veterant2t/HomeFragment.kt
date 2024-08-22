package com.example.veterant2t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.veterant2t.messagesTab.Message
import com.example.veterant2t.messagesTab.UnreadFragment

class HomeFragment : Fragment() {

    private lateinit var unreadFragment: UnreadFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        unreadFragment = UnreadFragment(null)

        // This gets the first two messages
        val firstTwoMessages = unreadFragment.getFirstTwoMessages()

        // And this updates the first message layout
        if (firstTwoMessages.isNotEmpty()) {
            val firstMessage = firstTwoMessages[0]
            view.findViewById<TextView>(R.id.subjectLine1).text = firstMessage.subject
            view.findViewById<TextView>(R.id.messageDescription1).text = firstMessage.body
            view.findViewById<TextView>(R.id.timeAgoText1).text = "2m" // Update with actual time logic
        }

        if (firstTwoMessages.size > 1) {
            val secondMessage = firstTwoMessages[1]
            view.findViewById<TextView>(R.id.subjectLine2).text = secondMessage.subject
            view.findViewById<TextView>(R.id.messageDescription2).text = secondMessage.body
            view.findViewById<TextView>(R.id.timeAgoText2).text = "2m" // Update with actual time logic
        }

        // Onclick functionality for the messages
        val messageLinearLayout: LinearLayout = view.findViewById(R.id.messageLinearLayout)
        val messageLinearLayout2: LinearLayout = view.findViewById(R.id.messageLinearLayout2)

        messageLinearLayout2.setOnClickListener {
            (activity as HomeScreen).binding.navView.selectedItemId = R.id.navigation_notifications
        }

        messageLinearLayout.setOnClickListener {
            (activity as HomeScreen).binding.navView.selectedItemId = R.id.navigation_notifications
        }
    }

    fun onNotificationClick(view: View) {
        val fragManager = parentFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.fragmentContainerView, NotifFragment())
        fragTransaction.commit()
    }
}