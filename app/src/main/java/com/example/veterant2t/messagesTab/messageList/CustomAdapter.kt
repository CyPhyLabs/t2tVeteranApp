package com.example.veterant2t.messagesTab.messageList

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.veterant2t.messagesTab.Message
import com.example.veterant2t.R

class CustomAdapter(val messageList:MutableList<Message>): RecyclerView.Adapter<MessageHolder>() {
    private var clickListener: IClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_container, parent, false)

        return MessageHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
    fun getColorHex(context: Context, colorResId: Int): String {
        val colorInt = ContextCompat.getColor(context, colorResId)
        return String.format("#%06X", 0xFFFFFF and colorInt)
    }
    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        val currentItem=messageList[position]
        holder.subjectBox.text = currentItem.subject
        holder.oneLineDescription.text = currentItem.body.substring(0, 15)
        holder.messageContainer.setOnClickListener(
            {
                clickListener?.onItemClick(currentItem.id, position)
            },
        )
        if(currentItem.acknowledge){

            holder.messageContainer.setBackgroundColor(Color.parseColor(getColorHex(holder.itemView.context, R.color.acknowledge)))
        }
        else{
            holder.messageContainer.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
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