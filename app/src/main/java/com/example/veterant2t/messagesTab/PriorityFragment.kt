package com.example.veterant2t.messagesTab

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veterant2t.NotifFragment
import com.example.veterant2t.R
import com.example.veterant2t.messagesTab.messageList.CustomAdapter
import com.example.veterant2t.messagesTab.MessageManager
import com.example.veterant2t.messagesTab.messageList.IClickListener
import java.util.UUID


class PriorityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_priority, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.priorityRecyclerView)

        val adapter:CustomAdapter = CustomAdapter(NotifFragment.MessageMaster.getPriorityMessages())

        adapter.setOnClickListener(object: IClickListener {
            override fun onItemClick(id: Int) {

                val builder:AlertDialog.Builder = AlertDialog.Builder(requireContext())
                val message:Message?=NotifFragment.MessageMaster.getMessageById(id)
                message?.acknowledge=true
                builder.setTitle(message?.subject)
                builder.setMessage(message?.body)
                builder.setNegativeButton("Close"
                ) { dialog, which -> dialog?.dismiss() }
                builder.show()
            }
        })
        recyclerView.layoutManager= LinearLayoutManager(this.context)
        recyclerView.adapter = adapter

    }



}