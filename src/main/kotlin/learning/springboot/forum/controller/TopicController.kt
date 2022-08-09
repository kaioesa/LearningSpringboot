package learning.springboot.forum.controller

import learning.springboot.forum.model.Topic
import learning.springboot.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAllTopics(): List<Topic> {
        return service.listTopics()
    }
}