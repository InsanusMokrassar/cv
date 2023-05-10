package dev.inmo.resume.client

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import dev.inmo.kslog.common.i
import dev.inmo.resume.client.containers.AnchorContainer
import dev.inmo.resume.client.containers.Box
import dev.inmo.resume.client.css.*
import dev.inmo.resume.client.drawers.*
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.client.utils.darkModeSetting
import dev.inmo.resume.client.utils.setSetting
import dev.inmo.resume.common.globalLogger
import dev.inmo.resume.common.models.Info
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody

@Composable
private fun HeaderElement(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Div({
        if (isActive) classes(CommonStyleSheet.primaryElement) else classes(CommonStyleSheet.secondaryElement)
        classes(CommonStyleSheet.cursorPointer, HeaderStyleSheet.element)
        onClick { onClick() }
    }) {
        Text(title)
    }
}

fun main() {
    val info = Info()

    val drawers = listOfNotNull(
        "About me" to ListDrawer(
            MeDrawer(info.me)
        ),
        info.projects ?.let {
            "My projects" to ListDrawer(
                listOf(H1Drawer("My projects")) + it.map { ProjectDrawer(it) }
            )
        },
        info.experience ?.let {
            "Experience" to ListDrawer(
                H1Drawer("Experience"),
                StyleDrawer(ExperienceDrawer.ExperienceStyles),
                it.map { ExperienceDrawer(it) }.let {
                    Drawer {
                        GridDrawer.DrawGrid {
                            it.forEach { it.invoke() }
                        }
                    }
                },
            )
        },
        info.education ?.let {
            "Education" to ListDrawer(
                H1Drawer("Education"),
                it.map { EducationDrawer(it) }.let {
                    Drawer {
                        GridDrawer.DrawGrid {
                            it.forEach { it.invoke() }
                        }
                    }
                }
            )
        },
        info.github ?.let {
            "Github" to ListDrawer(
                listOf(H1Drawer("My Github projects")) + GithubDrawer(it, CoroutineScope(Dispatchers.Default + SupervisorJob()))
            )
        }
    )
    val darkMode = mutableStateOf(darkModeSetting)

    window.onload = {
        document.title = info.me.name
        globalLogger.i("Hello! All the logs made with my library KSLog. You may find sources of that library here: https://github.com/InsanusMokrassar/KSLog")
        val centerDrawer = mutableStateOf<Drawer>(drawers.first().second)

        renderComposableInBody {
            Style(if (darkMode.value) ThemeStyleSheet.DARK else ThemeStyleSheet.LIGHT)
            Style(CommonStyleSheet)
            Style(CommonStyleSheet.Width)
            Style(AnchorStyleSheet)
            Style(RootAnchorStyleSheet)
            Style(HeaderStyleSheet)
            Style(GridElementsStyleSheet)

            @Composable
            fun HeaderDrawerElement(
                title: String,
                drawer: Drawer
            ) {
                HeaderElement(
                    title,
                    centerDrawer.value == drawer
                ) {
                    centerDrawer.value = drawer
                }
            }

            AnchorContainer(
                headerBuilder = {
                    Div({
                        classes(CommonStyleSheet.Width.expand, HeaderStyleSheet.container, RootAnchorStyleSheet.header)
                    }) {
                        HeaderElement(
                            "Dark mode",
                            darkMode.value
                        ) {
                            darkMode.value = !darkMode.value
                            darkModeSetting = darkMode.value
                        }
                        drawers.forEach { (title, drawer) ->
                            HeaderDrawerElement(title, drawer)
                        }
                    }
                },
                centerBuilder = {
                    Box({
                        classes(RootAnchorStyleSheet.center)
                    }) {
                        centerDrawer.value()
                    }
                }
            )
        }
    }
}
