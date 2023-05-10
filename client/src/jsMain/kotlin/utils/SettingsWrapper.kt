package dev.inmo.resume.client.utils

import kotlinx.browser.localStorage
import org.w3c.dom.set

fun getSetting(parameterName: String): String? {
    return localStorage.getItem(parameterName)
}

fun setSetting(parameterName: String, value: String?) {
    value ?.let {
        localStorage[parameterName] = value
    } ?: localStorage.removeItem(parameterName)
}
