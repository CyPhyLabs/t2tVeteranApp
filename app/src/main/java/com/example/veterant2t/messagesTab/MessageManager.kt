package com.example.veterant2t.messagesTab

public class MessageManager() {
    private val messages = mutableListOf<Message>()
    private val priorityMessages = mutableListOf<Message>()
    private val unreadMessages= mutableListOf<Message>()

    init {
        //Potentially Fetch messages from backend here?
        messages.add(Message(false,1, "Important Message1", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-01T12:00:00Z"))
        messages.add(Message(false,2, "Urgent Message2", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-02T12:00:00Z"))
        messages.add(Message(false,3, "Emergency Message3", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-03T12:00:00Z"))
        messages.add(Message(false,4, "Normal Message4", "This is a normal message.", "normal", "all_veterans", "queued", null, "2021-09-04T12:00:00Z"))
        messages.add(Message(false,5, "Important Message5", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-05T12:00:00Z"))
        messages.add(Message(false,6, "Urgent Message6", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-06T12:00:00Z"))
        messages.add(Message(false,7, "Emergency Message7", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-07T12:00:00Z"))
        messages.add(Message(false,8, "Normal Message8", "This is a normal message.", "normal", "all_veterans", "queued", null, "2021-09-08T12:00:00Z"))
        messages.add(Message(false,9, "Important Message9", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-09T12:00:00Z"))
        messages.add(Message(false,10, "Urgent Message10", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-10T12:00:00Z"))
        messages.add(Message(false,11, "Emergency Message11", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-11T12:00:00Z"))
        for (message in messages){
            if (message.priority == "urgent" || message.priority == "emergency"){
                priorityMessages.add(message)
            }
        }
        for (message in messages){
            if (!message.acknowledge){
                unreadMessages.add(message)
            }
        }
    }


    fun getMessages(): MutableList<Message> {
        return messages
    }

    fun updateMessageList(){
        priorityMessages.clear()
        unreadMessages.clear()
        for (message in messages){
        if ((message.priority == "urgent" || message.priority == "emergency") && !message.acknowledge){
                priorityMessages.add(message)
            }

        if (!message.acknowledge) {
            unreadMessages.add(message)
        }
        }

    }

    fun removeAtIndex(index:Int,type:String){
        if(type=="priority"){
            priorityMessages.removeAt(index)
        }
        else if(type=="unread"){
            unreadMessages.removeAt(index)
        }
    }

    fun indexToRemoveAtPriority(id:Int):Int{
        for (index in 0 until priorityMessages.size){
            if (priorityMessages[index].id == id){
                return index
            }
        }
        return -1
    }

    fun indexToRemoveAtUnread(id:Int):Int{
        for (index in 0 until unreadMessages.size){
            if (unreadMessages[index].id == id){
                return index
            }
        }
        return -1
    }

    fun getPriorityMessages(): MutableList<Message> {
        return  priorityMessages
    }

    fun getUnreadMessages(): MutableList<Message> {
        return unreadMessages
    }


    fun getMessageById(id: Int): Message? {
        return messages.find { it.id == id }
    }

}