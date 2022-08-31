package learning.springboot.forum.service

import learning.springboot.forum.entity.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var listOfUsers: List<User>) {

    init {
        val users = User(
            1, "Jonas", "jonas@example.com"
        )
        listOfUsers = Arrays.asList(users)
    }

    fun searchUserById(id: Long): User {
        return listOfUsers.stream().filter { a ->
            a.id == id
        }.findFirst().get()
    }

}
