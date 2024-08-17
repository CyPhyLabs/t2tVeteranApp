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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the RecyclerView in the layout
        val recyclerView = view.findViewById<RecyclerView>(R.id.unreadRecyclerView)

        // Create an adapter with the priority messages from MessageMaster
        val adapter:CustomAdapter = CustomAdapter(NotifFragment.MessageMaster.getUnreadMessages())

        // Set an item click listener for the adapter
        adapter.setOnClickListener(object: IClickListener {
            override fun onItemClick(id: Int, position: Int) {
                // Create an AlertDialog to show the message details
                val builder:AlertDialog.Builder = AlertDialog.Builder(requireContext())
                val message:Message?=NotifFragment.MessageMaster.getMessageById(id)
                message?.acknowledge=true
                builder.setTitle(message?.subject)
                builder.setMessage(message?.body)
                builder.setNegativeButton("Close"
                ) { dialog, which -> run(){
                    dialog?.dismiss()

                    val index = NotifFragment.MessageMaster.indexToRemoveAtUnread(id)
                    NotifFragment.MessageMaster.removeAtIndex(index,"unread")
                    adapter.notifyItemRemoved(index)
                } }
                builder.show()
            }
        })
        recyclerView.layoutManager= LinearLayoutManager(this.context)
        recyclerView.adapter = adapter

    }
}