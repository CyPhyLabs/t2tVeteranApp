package com.example.veterant2t.messagesTab

public class MessageManager() {
    private val messages = mutableListOf<Message>()


    init {
        //Potentially Fetch messages from backend here?
        messages.add(Message(1, "Important Message", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-01T12:00:00Z"))
        messages.add(Message(2, "Urgent Message", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-02T12:00:00Z"))
        messages.add(Message(3, "Emergency Message", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-03T12:00:00Z"))
        messages.add(Message(4, "Normal Message", "This is a normal message.", "normal", "all_veterans", "queued", null, "2021-09-04T12:00:00Z"))
        messages.add(Message(5, "Important Message", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-05T12:00:00Z"))
        messages.add(Message(6, "Urgent Message", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-06T12:00:00Z"))
        messages.add(Message(7, "Emergency Message", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-07T12:00:00Z"))
        messages.add(Message(8, "Normal Message", "This is a normal message.", "normal", "all_veterans", "queued", null, "2021-09-08T12:00:00Z"))
        messages.add(Message(9, "Important Message", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-09T12:00:00Z"))
        messages.add(Message(10, "Urgent Message", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-10T12:00:00Z"))
        messages.add(Message(11, "Emergency Message", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-11T12:00:00Z"))

    }


    fun getMessages(): List<Message> {
        return messages
    }

    fun updateMessageList(){
        //call endpoint to get new messages
    }

    fun getPriorityMessages(): List<Message> {
        return messages.filter { (it.priority == "urgent" || it.priority == "emergency") && (it.acknowledge==false) }
    }

    fun updateAcknowledge(id: Int){
        val message = messages.find { it.id == id }
        message?.acknowledge = true
    }
    fun getUnreadMessages(): List<Message> {
        return messages.filter { !it.acknowledge }
    }

    fun getMessageById(id: Int): Message? {
        return messages.find { it.id == id }
    }

}