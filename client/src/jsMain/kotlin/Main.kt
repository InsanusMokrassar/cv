package dev.inmo.resume.client

import dev.inmo.kslog.common.i
import dev.inmo.resume.common.globalLogger
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = {
        globalLogger.i("Hello! All the logs made with my library KSLog. You may find sources of that library here: https://github.com/InsanusMokrassar/KSLog")
    }
}
