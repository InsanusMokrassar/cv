package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.containers.AnchorContainer
import dev.inmo.resume.client.models.Experience
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

class ExperienceDrawer(
    private val experience: Experience
) : Drawer {
    @Composable
    override fun invoke() {
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
