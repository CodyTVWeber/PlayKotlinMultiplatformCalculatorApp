package com.example.playkotlinmultiplatformcalculatorapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform