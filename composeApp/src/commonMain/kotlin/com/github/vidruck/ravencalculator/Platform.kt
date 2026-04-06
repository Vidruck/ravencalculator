package com.github.vidruck.ravencalculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform