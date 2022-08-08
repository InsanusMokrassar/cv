package dev.inmo.resume.client

import androidx.compose.runtime.mutableStateOf
import dev.inmo.kslog.common.i
import dev.inmo.resume.client.containers.AnchorContainer
import dev.inmo.resume.client.css.*
import dev.inmo.resume.common.globalLogger
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    window.onload = {
        globalLogger.i("Hello! All the logs made with my library KSLog. You may find sources of that library here: https://github.com/InsanusMokrassar/KSLog")
        val darkMode = mutableStateOf(false)
        renderComposableInBody {
            Style(if (darkMode.value) ThemeStyleSheet.DARK else ThemeStyleSheet.LIGHT)
            Style(CommonStyleSheet)
            Style(AnchorStyleSheet)

            AnchorContainer(
                headerBuilder = {
                    Div({
                        onClick { darkMode.value = !darkMode.value }
                        classes(CommonStyleSheet.cursorPointer)
                        if (darkMode.value) classes(CommonStyleSheet.activeClass)
                    }) {
                        Text("Dark mode")
                    }
                    Div({
                        classes(CommonStyleSheet.primaryElement)
                    }) {
                        Text("Sample primary")
                    }
                    Div({
                        classes(CommonStyleSheet.secondaryElement)
                    }) {
                        Text("Sample secondary")
                    }
                }
            )
        }
    }
}
