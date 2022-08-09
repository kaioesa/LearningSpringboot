package learning.springboot.forum.service

import learning.springboot.forum.model.Course
import learning.springboot.forum.model.Topic
import learning.springboot.forum.model.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class TopicService {
    fun listTopics(): List<Topic> {

        val topic = Topic(
            1,
            "How to use Regex",
            "How can i verify if a form have a valid email",
            course = Course(
                1,
                "Kotlin",
                "Programming"
            ),
            author = User(
                1,
                "John Doe",
                "johndoe@email.com"
            )
        )
        return Arrays.asList(topic, topic, topic)
    }
}