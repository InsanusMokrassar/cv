package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.flex
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.value

object CommonStyleSheet : StyleSheet() {
    object Width : StyleSheet() {
        val expandTemplate = CSSTemplate {
            flex(1)
        }
        val expand by style(expandTemplate)
    }

    val activeClass by style {

    }

    val cursorPointer by style {
        cursor("pointer")
        property("user-select", "none")
    }

    val primaryElement by style {
        backgroundColor(ThemeStyleSheet.primaryColor.value())
        color(ThemeStyleSheet.primaryTextColor.value())
    }

    val secondaryElement by style {
        backgroundColor(ThemeStyleSheet.secondaryColor.value())
        color(ThemeStyleSheet.secondaryTextColor.value())
    }

    init {
        root style {
            backgroundColor(ThemeStyleSheet.backgroundNeutralColor.value())
            color(ThemeStyleSheet.neutralTextColor.value())
        }

        selector("body") style {
            margin(0.px)
        }
    }
}
