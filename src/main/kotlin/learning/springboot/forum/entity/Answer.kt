package learning.springboot.forum.entity

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean,
)
