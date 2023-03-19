package dev.inmo.resume.client.css

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import dev.inmo.resume.client.utils.onLargeScreen
import dev.inmo.resume.client.utils.onMediumScreen
import dev.inmo.resume.client.utils.styleOnLargeScreen
import dev.inmo.resume.client.utils.styleOnMediumScreen
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.borderWidth
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexGrow
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.css.style
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.width

object HeaderStyleSheet : StyleSheet() {
    val container by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
    }
    val element by style {
        padding(4.px)
        textAlign("center")
        styleOnLargeScreen {
            minWidth(124.px)
        }
        styleOnMediumScreen {
            minWidth(124.px)
        }

    }
    var headerElementBorderWidth = mutableStateOf(2.px)
    var headerElementBorderIntermediateWidth = mutableStateOf(1.px)
    var headerElementBorderRadius = mutableStateOf(5.px)
    val headerElementBorderColor = ThemeStyleSheet.primaryColor

    init {
        ".$element:first-child".style {
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
        ".$element:last-child".style {
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
        ".$element:last-child:first-child".style {
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
        ".$element:not(:last-child):not(:first-child)".style {
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
        ".$element".style {
            border {
                style(LineStyle.Solid)
                this.color = headerElementBorderColor.value()
            }
        }
    }
}
