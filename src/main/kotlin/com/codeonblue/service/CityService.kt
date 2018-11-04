package com.codeonblue.service

import com.codeonblue.model.City

interface CityService {

    fun getAllCities(): List<City>;
}