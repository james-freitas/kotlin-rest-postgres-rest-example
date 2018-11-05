package com.codeonblue.service

import com.codeonblue.model.City
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class CityServiceImpl : CityService {


    object Cities: Table() {
        val id = integer("id").autoIncrement().primaryKey()
        val name = varchar("name", 50)
    }

    override fun getAllCities(): List<City> {

        transaction {

            SchemaUtils.create(Cities)

            addLogger(StdOutSqlLogger)

            val rioDeJaneiro = Cities.insert {
                it[name] = "Rio de Janeiro"
            } get Cities.id

        }
        var cities = emptyList<City>();
        transaction {
            cities =  Cities.selectAll().map {  City(it[Cities.id], it[Cities.name]) };
        }
        return cities;
    }

}