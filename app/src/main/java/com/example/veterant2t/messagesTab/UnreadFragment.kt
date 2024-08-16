package com.example.veterant2t.messagesTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veterant2t.NotifFragment
import com.example.veterant2t.R
import com.example.veterant2t.messagesTab.messageList.CustomAdapter
import com.example.veterant2t.messagesTab.messageList.IClickListener


class UnreadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unread, container, false)
    }
}