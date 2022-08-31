package learning.springboot.forum.mapper

import learning.springboot.forum.dto.TopicView
import learning.springboot.forum.entity.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            creationData = t.createdAt,
        )
    }
}