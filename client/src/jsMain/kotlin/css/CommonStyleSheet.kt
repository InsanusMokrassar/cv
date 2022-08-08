package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.*

object CommonStyleSheet : StyleSheet() {
    object Width {
        val expand = CSSTemplate {
            flex(1)
        }
    }

    val activeClass by style {

    }

    val cursorPointer by style {
        cursor("pointer")
        property("user-select", "none")
    }

    val primaryElement by style {
        backgroundColor(ThemeStyleSheet.backgroundPrimaryColor.value())
        color(ThemeStyleSheet.primaryTextColor.value())
    }

    val secondaryElement by style {
        backgroundColor(ThemeStyleSheet.backgroundSecondaryColor.value())
        color(ThemeStyleSheet.secondaryTextColor.value())
    }

    init {
        root style {
            backgroundColor(ThemeStyleSheet.backgroundPrimaryColor.value())
            color(ThemeStyleSheet.primaryTextColor.value())
        }
    }
}
