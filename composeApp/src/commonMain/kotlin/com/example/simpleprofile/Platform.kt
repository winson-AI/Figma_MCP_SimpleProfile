package com.example.simpleprofile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform