package com.example.veterant2t.messagesTab

import java.util.UUID

data class Message(
    val id: Int,
    val subject: String = "Important Message",
    val body: String = "This is an important message.",
    val priority: String = "normal",
    val target_audience: String = "all_veterans",
    val status: String = "queued",
    val scheduled_time: String? = null,
    val created_at: String,
    var acknowledge:Boolean = false
)

/*
id (UUID): Unique identifier for the message.
subject (String): Subject line of the message.
body (Text): Body content of the message.
priority (String): Priority level (e.g., "normal", "urgent", "emergency").
target_audience (String): Target audience (e.g., "all_veterans", "specific_group").
status (String): Status of the message (e.g., "queued", "sent", "failed").
scheduled_time (DateTime, nullable): Time when the message is scheduled to be sent.
created_at (DateTime): Timestamp when the message was created.
updated_at (DateTime): Timestamp when the message was last updated.
 */