package dev.inmo.resume.client.containers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.css.CommonStyleSheet
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Box(
    attrs: AttrBuilderContext<HTMLDivElement>? = {
        classes(CommonStyleSheet.Width.expand)
    },
    content: ContentBuilder<HTMLDivElement>? = null
) = Div(attrs, content)
