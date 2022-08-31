package learning.springboot.forum.service

import learning.springboot.forum.dto.NewTopicForm
import learning.springboot.forum.dto.TopicView
import learning.springboot.forum.dto.UpdateTopicForm
import learning.springboot.forum.exception.NotFoundException
import learning.springboot.forum.mapper.TopicFormMapper
import learning.springboot.forum.mapper.TopicViewMapper
import learning.springboot.forum.entity.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var listOfTopics: List<Topic> = ArrayList(),

    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found!",
) {
    fun listTopics(): List<TopicView> {
        return listOfTopics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getTopicById(id: Long): TopicView {
        val topicById = listOfTopics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topicById)
    }

    fun createTopic(form: NewTopicForm): TopicView {
        val topicMap = topicFormMapper.map(form)

        topicMap.id = listOfTopics.size.toLong() + 1

        listOfTopics = listOfTopics.plus(topicMap)

        return topicViewMapper.map(topicMap)
    }

    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topicById = listOfTopics.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        val newTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topicById.author,
            course = topicById.course,
            answers = topicById.answers,
            status = topicById.status
        )

        listOfTopics = listOfTopics.minus(topicById).plus(newTopic)

        return topicViewMapper.map(newTopic)
    }

    fun deleteTopic(id: Long) {
        val topicById = listOfTopics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
//            .orElseThrow { NotFoundException(notFoundMessage) }
        listOfTopics = listOfTopics.minus(topicById)
    }
}

// NewTopicForm === entry DTO
// TopicView === exit DTO