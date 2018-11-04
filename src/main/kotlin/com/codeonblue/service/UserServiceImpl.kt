package com.codeonblue.service

import com.codeonblue.model.User
import java.util.concurrent.atomic.AtomicInteger

class UserServiceImpl : UserService {

    val users = hashMapOf(
        1 to User(id = 1, name = "Alice", email = "alice@alice.kt"),
        2 to User(id = 2, name = "Bob", email = "bob@bob.kt"),
        3 to User(id = 3, name = "Carol", email = "carol@carol.kt"),
        4 to User(id = 4, name = "Dave", email = "dave@dave.kt")
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    override fun getAllUsers(): List<User> {
        return ArrayList(users.values)
    }

    override fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users.put(id, User(id = id, name = name, email = email))
    }

    override fun findByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    override fun update(id: Int, user: User) {
        users.put(id, User(id = id, name = user.name, email = user.email))
    }

    override fun delete(id: Int) {
        users.remove(id)
    }

    override fun findById(id: Int): User? {
        return users[id]
    }
}