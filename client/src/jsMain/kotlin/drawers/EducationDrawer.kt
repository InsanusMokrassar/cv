package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.common.models.Education
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

class EducationDrawer(
    private val education: Education
) : Drawer {
    @Composable
    override fun invoke() {
        H3 {
            Text(education.grade)
        }
        P()
        Span {
            B { Text("University:") }
            Span { Text(" ") }
            Text(education.university)
        }
        P()
        Span {
            B { Text("Major:") }
            Span { Text(" ") }
            Text(education.major)
        }
        P()
        Span {
            B { Text("Year of graduation:") }
            Span { Text(" ") }
            Text(education.yearOfGraduation)
        }

        education.additional.forEach { (k, v) ->
            P()
            Span {
                B { Text("$k:") }
                Span { Text(" ") }
                Text(v)
            }
        }
    }
}
