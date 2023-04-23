package dev.inmo.resume.client.css

import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.flex
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.css.transitions
import org.jetbrains.compose.web.css.value

@OptIn(ExperimentalComposeWebApi::class)
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

    val neutralElement by style {
        backgroundColor(ThemeStyleSheet.neutralColor.value())
        color(ThemeStyleSheet.neutralTextColor.value())
    }

    init {
        root style {
            backgroundColor(ThemeStyleSheet.backgroundNeutralColor.value())
            color(ThemeStyleSheet.neutralTextColor.value())
            transitions {
                properties("color", "background-color")
                defaultTimingFunction(AnimationTimingFunction.Ease)
                defaultDuration(0.25.s)
            }
            property("scrollbar-gutter", "stable")
        }

        selector("body") style {
            margin(0.px)
        }

        selector("a") style {
            color(ThemeStyleSheet.neutralTextColor.value())
        }
    }
}
