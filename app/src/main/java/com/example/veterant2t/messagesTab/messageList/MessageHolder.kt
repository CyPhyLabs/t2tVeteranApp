package com.example.veterant2t.messagesTab.messageList

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.veterant2t.R

class MessageHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    open val subjectBox:TextView = itemView.findViewById(R.id.subjectLine)
    open val oneLineDescription:TextView=itemView.findViewById(R.id.messageDescription)
    open val priorityImage:ImageView=itemView.findViewById(R.id.messageIcon)
}