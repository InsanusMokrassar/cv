package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

class H1Drawer(private val title: String) : Drawer {
    @Composable
    override fun invoke() {
        H2 { Text(title) }
    }
}
