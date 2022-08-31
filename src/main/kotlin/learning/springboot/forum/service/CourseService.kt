package learning.springboot.forum.service

import learning.springboot.forum.entity.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var listOfCourses: List<Course>) {

    init {
        val course = Course(
            1, "Kotlin", "Programming"
        )
        listOfCourses = Arrays.asList(course)
    }

    fun searchCourseById(id: Long): Course {
        return listOfCourses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

}
