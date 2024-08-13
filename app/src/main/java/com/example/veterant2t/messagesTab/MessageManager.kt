package com.example.veterant2t.messagesTab

class MessageManager() {
    private val messages = mutableListOf<Message>()

    init {
        //Potentially Fetch messages from backend here?
        messages.add(Message(1, "Important Message", "This is an important message.", "normal", "all_veterans", "queued", null, "2021-09-01T12:00:00Z"))
        messages.add(Message(2, "Urgent Message", "This is an urgent message.", "urgent", "all_veterans", "queued", null, "2021-09-02T12:00:00Z"))
        messages.add(Message(3, "Emergency Message", "This is an emergency message.", "emergency", "all_veterans", "queued", null, "2021-09-03T12:00:00Z"))
    }


    fun getMessages(): List<Message> {
        return messages
    }

    fun getMessageById(id: Long): Message? {
        return messages.find { it.id == id }
    }

}