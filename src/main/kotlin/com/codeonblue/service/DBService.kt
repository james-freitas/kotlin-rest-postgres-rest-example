package com.codeonblue.service

import org.jetbrains.exposed.sql.Database

class DBService {

    init {
        // Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
        Database.connect("jdbc:postgresql://localhost:5432/kotlinpostgresdb?user=postgres&password=postgres",
            driver = "org.postgresql.Driver")
    }
}