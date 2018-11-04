package com.codeonblue.model

import java.math.BigDecimal

data class Product (
    val id: Int,
    val name: String,
    val email: String,
    val price: BigDecimal,
    val imageUrl: String
)