package com.codeonblue.app

import com.codeonblue.model.User
import com.codeonblue.service.CityService
import com.codeonblue.service.UserService
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

import org.koin.standalone.KoinComponent

import org.koin.standalone.inject

class KotlinApplication : KoinComponent {

    private val userService by inject<UserService>()
    private val cityService by inject<CityService>()

    init {
        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("Not found") }
        }.start(7000)

        app.routes {

            get("/cities") { ctx ->
                ctx.json(cityService.getAllCities())
            }

            get("/users") { ctx ->
                ctx.json(userService.getAllUsers())
            }

            get("/users/:user-id") { ctx ->
                ctx.json(userService.findById(ctx.pathParam("user-id").toInt())!!)
            }

            get("/users/email/:email") { ctx ->
                ctx.json(userService.findByEmail(ctx.pathParam("email"))!!)
            }

            post("/users") { ctx ->
                val user = ctx.body<User>()
                userService.save(name = user.name, email = user.email)
                ctx.status(201)
            }

            patch("/users/:user-id") { ctx ->
                val user = ctx.body<User>()
                userService.update(
                    id = ctx.pathParam("user-id").toInt(),
                    user = user
                )
                ctx.status(204)
            }

            delete("/users/:user-id") { ctx ->
                userService.delete(ctx.pathParam("user-id").toInt())
                ctx.status(204)
            }
/*
            get("/products") { ctx ->
                ctx.json(productService.getAllProducts())
            }
*/
        }
    }
}