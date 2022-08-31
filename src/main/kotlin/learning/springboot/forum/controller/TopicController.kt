package learning.springboot.forum.controller

import learning.springboot.forum.dto.NewTopicForm
import learning.springboot.forum.dto.TopicView
import learning.springboot.forum.dto.UpdateTopicForm
import learning.springboot.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAllTopics(): List<TopicView> {
        return service.listTopics()
    }

    @GetMapping("/{id}")
    fun getTopicsById(@PathVariable id: Long): TopicView {
        return service.getTopicById(id)
    }

    @PostMapping
    fun createTopic(
        @RequestBody @Valid form: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.createTopic(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(form)

        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}