package com.example.veterant2t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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