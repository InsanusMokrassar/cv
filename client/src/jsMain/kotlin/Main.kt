package dev.inmo.resume.client

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import dev.inmo.kslog.common.i
import dev.inmo.resume.client.containers.AnchorContainer
import dev.inmo.resume.client.containers.Box
import dev.inmo.resume.client.css.*
import dev.inmo.resume.client.drawers.EducationDrawer
import dev.inmo.resume.client.drawers.ExperienceDrawer
import dev.inmo.resume.client.drawers.H1Drawer
import dev.inmo.resume.client.drawers.ListDrawer
import dev.inmo.resume.client.drawers.MeDrawer
import dev.inmo.resume.client.drawers.ProjectDrawer
import dev.inmo.resume.client.models.Info
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.common.globalLogger
import kotlinx.browser.window
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
        if (isActive) classes(CommonStyleSheet.activeClass)
        classes(CommonStyleSheet.cursorPointer, HeaderStyleSheet.element, CommonStyleSheet.secondaryElement)
        onClick { onClick() }
    }) {
        Text(title)
    }
}

fun main() {
    val info = Info()

    val experienceDrawer = ListDrawer(
        listOf(H1Drawer("Experience")) + info.experience.map { ExperienceDrawer(it) }
    )
    val educationDrawer = ListDrawer(
        listOf(H1Drawer("Education")) + info.education.map { EducationDrawer(it) }
    )
    val meDrawer = ListDrawer(
        listOf(H1Drawer("About me"), MeDrawer(info.me))
    )
    val projectsDrawer = ListDrawer(
        listOf(H1Drawer("My projects")) + info.projects.map { ProjectDrawer(it) }
    )
    window.onload = {
        globalLogger.i("Hello! All the logs made with my library KSLog. You may find sources of that library here: https://github.com/InsanusMokrassar/KSLog")
        val darkMode = mutableStateOf(false)
        val centerDrawer = mutableStateOf<Drawer>(meDrawer)

        renderComposableInBody {
            Style(ThemeStyleSheet(true))
            Style(if (darkMode.value) ThemeStyleSheet.DARK else ThemeStyleSheet.LIGHT)
            Style(CommonStyleSheet)
            Style(CommonStyleSheet.Width)
            Style(AnchorStyleSheet)
            Style(RootAnchorStyleSheet)
            Style(HeaderStyleSheet)

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
                        classes(HeaderStyleSheet.container)
                    }) {
                        HeaderElement(
                            "Dark mode",
                            darkMode.value
                        ) {
                            darkMode.value = !darkMode.value
                        }
                        HeaderDrawerElement(
                            "About me",
                            meDrawer
                        )
                        HeaderDrawerElement(
                            "My projects",
                            projectsDrawer
                        )
                        HeaderDrawerElement(
                            "Experience",
                            experienceDrawer
                        )
                        HeaderDrawerElement(
                            "Education",
                            educationDrawer
                        )
                    }
                },
                leftBuilder = {
                    Div({
                        classes()
                    }) {
                        Text("Left")
                    }
                },
                centerBuilder = {
                    Box({
                        classes(RootAnchorStyleSheet.center)
                    }) {
                        centerDrawer.value()
                    }
                },
                rightBuilder = {
                    Div({
                        classes()
                    }) {
                        Text("Right")
                    }
                }
            )
        }
    }
}
