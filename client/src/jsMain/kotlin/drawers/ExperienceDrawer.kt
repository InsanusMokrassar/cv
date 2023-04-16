package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.common.models.Experience
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

class ExperienceDrawer(
    private val experience: Experience
) : Drawer {
    object ExperienceStyles : StyleSheet() {
        val container by style {
            margin(8.px)
        }
    }
    @Composable
    override fun invoke() {
        Div({ classes(ExperienceStyles.container) }) {
            H3 {
                Text("${experience.position} in ")
                experience.companyLink ?.let {
                    A(experience.companyLink) { Text(experience.company) }
                } ?: Text(experience.company)
            }
            P()
            Span {
                B { Text("Period:") }
                Span { Text(" ") }
                Text(experience.period)
            }
            P()
            Span {
                B { Text("Location:") }
                Span { Text(" ") }
                Text(experience.location)
            }
            experience.additional.forEach { (k, v) ->
                P()
                Span {
                    B { Text("$k:") }
                    Span { Text(" ") }
                    Text(v)
                }
            }
        }
    }
}
