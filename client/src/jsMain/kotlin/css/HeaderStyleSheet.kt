package dev.inmo.resume.client.css

import androidx.compose.runtime.mutableStateOf
import dev.inmo.resume.client.utils.ExtraSmallScreen
import dev.inmo.resume.client.utils.styleOn
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.borderWidth
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.flexGrow
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.not
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.style
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.width

object HeaderStyleSheet : StyleSheet() {
    var headerElementBorderWidth = mutableStateOf(2.px)
    var headerElementBorderIntermediateWidth = mutableStateOf(1.px)
    var headerElementBorderRadius = mutableStateOf(5.px)
    val headerElementBorderColor = ThemeStyleSheet.primaryColor

    val container by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Stretch)

        styleOn(not(ExtraSmallScreen)) {
            alignItems(AlignItems.Center)
        }
        styleOn(ExtraSmallScreen) {
            flexDirection(FlexDirection.Column)
        }
    }
    val element by style {
        padding(4.px)
        textAlign("center")
        flexGrow(1)

        border {
            style(LineStyle.Solid)
            this.color = headerElementBorderColor.value()
            width(0.px)
        }

        styleOn(not(ExtraSmallScreen)) {
            (self + firstChild) style {
                borderRadius(
                    bottomLeft = headerElementBorderRadius.value,
                    topLeft = 0.px,
                    topRight = 0.px,
                    bottomRight = 0.px
                )
                borderWidth(
                    top = 0.px,
                    left = headerElementBorderWidth.value,
                    bottom = headerElementBorderWidth.value,
                    right = headerElementBorderIntermediateWidth.value
                )
            }
            (self + lastChild) style {
                borderRadius(
                    bottomLeft = 0.px,
                    topLeft = 0.px,
                    topRight = 0.px,
                    bottomRight = headerElementBorderRadius.value
                )
                borderWidth(
                    top = 0.px,
                    left = headerElementBorderIntermediateWidth.value,
                    bottom = headerElementBorderWidth.value,
                    right = headerElementBorderWidth.value
                )
            }
            ((self + firstChild) + (self + lastChild)) style {
                borderRadius(
                    bottomLeft = headerElementBorderRadius.value,
                    topLeft = 0.px,
                    topRight = 0.px,
                    bottomRight = headerElementBorderRadius.value
                )
                borderWidth(
                    top = 0.px,
                    left = headerElementBorderWidth.value,
                    bottom = headerElementBorderWidth.value,
                    right = headerElementBorderWidth.value
                )
            }
            ((self + not(firstChild)) + (self + not(lastChild))) style {
                borderRadius(
                    bottomLeft = 0.px,
                    topLeft = 0.px,
                    topRight = 0.px,
                    bottomRight = 0.px
                )
                borderWidth(
                    top = 0.px,
                    left = headerElementBorderIntermediateWidth.value,
                    bottom = headerElementBorderWidth.value,
                    right = headerElementBorderIntermediateWidth.value
                )
            }
        }
    }
}
