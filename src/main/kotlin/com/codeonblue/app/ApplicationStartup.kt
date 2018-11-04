package com.codeonblue.app

import com.codeonblue.service.*
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin

val ApplicationModule = applicationContext {
    bean { UserServiceImpl() as UserService }
    bean { CityServiceImpl() as CityService }
   // bean { ProductServiceImpl() as ProductService }
}

fun main(args: Array<String>) {
    startKoin(listOf(ApplicationModule))
    DBService()
    KotlinApplication()
}
