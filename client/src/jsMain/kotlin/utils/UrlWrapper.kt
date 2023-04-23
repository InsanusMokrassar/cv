package dev.inmo.resume.client.utils

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams

private val params: URLSearchParams
    get() = URLSearchParams(window.location.search)

fun getUrlParameter(parameterName: String): String? {
    return params.get(parameterName)
}

fun setUrlParameter(parameterName: String, value: String?) {
    val params = params
    value ?.let {
        params.set(parameterName, value)
    } ?: params.delete(parameterName)
    window.history.pushState(null, document.title, "${window.location.origin.dropSuffix("/")}/${window.location.pathname.dropSuffix("?")}?${params}${window.location.hash.takeIf { it.isNotBlank() } ?.let { "#$it" } ?: ""}")
}
