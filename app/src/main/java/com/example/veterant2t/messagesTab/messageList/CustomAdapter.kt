package com.example.veterant2t.messagesTab.messageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterant2t.messagesTab.Message
import com.example.veterant2t.R

class CustomAdapter(val messageList:List<Message>): RecyclerView.Adapter<MessageHolder>() {
    private var clickListener: IClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_container, parent, false)

        return MessageHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        val currentItem=messageList[position]
        holder.subjectBox.text = currentItem.subject
        holder.oneLineDescription.text = currentItem.body.substring(0, 15)
        holder.messageContainer.setOnClickListener(
            {
                clickListener?.onItemClick(currentItem.id)
            },
        )
        when(currentItem.priority){
            "Priority" -> holder.priorityImage.setImageResource(R.mipmap.priorityicon)
            "Emergency" -> holder.priorityImage.setImageResource(R.mipmap.ic_launcher)
            "Normal" -> holder.priorityImage.setImageResource(R.mipmap.openmessageicon)
        }
    }

    fun setOnClickListener(listener: IClickListener){
        this.clickListener=listener
    }



}