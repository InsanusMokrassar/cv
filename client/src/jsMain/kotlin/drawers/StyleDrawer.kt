package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet

class StyleDrawer(val styleSheets: List<StyleSheet>) : Drawer {
    constructor(vararg styleSheets: StyleSheet) : this(styleSheets.toList())
    @Composable
    override fun invoke() {
        styleSheets.forEach { Style(it) }
    }
}
