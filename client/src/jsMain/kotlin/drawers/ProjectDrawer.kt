package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.common.models.Project
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

class ProjectDrawer(
    private val project: Project
) : Drawer {
    @Composable
    override fun invoke() {
        H3 {
            A(project.link) { Text(project.title) }
        }

        project.description ?.let {
            P()
            Span {
                Text(it)
            }
        }
    }
}
