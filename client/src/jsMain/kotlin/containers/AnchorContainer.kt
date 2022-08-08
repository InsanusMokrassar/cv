package dev.inmo.resume.client.containers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.css.AnchorStyleSheet
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * |     <-header->      |
 * |---------------------|
 * |left| <-main-> |right|
 * |---------------------|
 * |     <-footer->      |
 */

@Composable
fun AnchorContainer(
    headerBuilder: ContentBuilder<HTMLDivElement>? = null,
    leftBuilder: ContentBuilder<HTMLDivElement>? = null,
    rightBuilder: ContentBuilder<HTMLDivElement>? = null,
    footerBuilder: ContentBuilder<HTMLDivElement>? = null,
    centerBuilder: ContentBuilder<HTMLDivElement>? = null,
) {
    Div({ classes(AnchorStyleSheet.container) }) {
        headerBuilder ?.let { Div({ classes(AnchorStyleSheet.header) }, it) }

        if (leftBuilder != null || centerBuilder != null || rightBuilder != null) {
            Div({ classes(AnchorStyleSheet.middle) }) {
                leftBuilder ?.let { Div({ classes(AnchorStyleSheet.leftSide) }, it) }
                centerBuilder ?.let { Div({ classes(AnchorStyleSheet.center) }, it) }
                rightBuilder ?.let { Div({ classes(AnchorStyleSheet.rightSide) }, it) }
            }
        }

        footerBuilder ?.let { Div({ classes(AnchorStyleSheet.footer) }, it) }
    }
}
