package org.rzcode.rzcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform