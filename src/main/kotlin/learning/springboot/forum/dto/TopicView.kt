package learning.springboot.forum.dto

import learning.springboot.forum.entity.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val creationData: LocalDateTime
)
