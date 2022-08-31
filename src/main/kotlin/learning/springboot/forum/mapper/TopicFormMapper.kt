package learning.springboot.forum.mapper

import learning.springboot.forum.dto.NewTopicForm
import learning.springboot.forum.entity.Topic
import learning.springboot.forum.service.CourseService
import learning.springboot.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchCourseById(t.idCourse),
            author = userService.searchUserById(t.idAuthor)
        )
    }
}