package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.mm
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

value class DividerDrawer private constructor(
    private val style: DividerStyles
) : Drawer {
    private class DividerStyles(color: CSSColorValue) : StyleSheet() {
        val divider by style {
            padding(8.mm, 0.mm)
            backgroundColor(color)
            margin(0.mm)
        }
    }

    constructor(color: CSSColorValue = Color.transparent) : this(DividerStyles(color))

        @Composable
    override fun invoke() {
        Style(style)
        Div({ classes(style.divider) })
    }
}
