package com.codeonblue.service

import com.codeonblue.model.User

interface UserService {

    fun getAllUsers(): List<User>

    fun findById(id: Int): User?

    fun save(name: String, email: String)

    fun findByEmail(email: String): User?

    fun update(id: Int, user: User)

    fun delete(id: Int)
}