package dev.inmo.resume.client.css

import dev.inmo.resume.client.css.CommonStyleSheet.style
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.variable

class ThemeStyleSheet private constructor(darkTheme: Boolean) : StyleSheet() {
    init {
        root style {
            variable(backgroundNeutralColor.name, if (darkTheme) rgb(40, 41, 35) else rgb(240, 240, 240))
            variable(backgroundPrimaryColor.name, if (darkTheme) Color("#a5b1c2") else Color("#3867d6"))
            variable(backgroundSecondaryColor.name, if (darkTheme) Color("#4b6584") else Color("#2d98da"))
            variable(neutralColor.name, if (darkTheme) rgb(99, 89, 133) else rgb(255, 242, 242))
            variable(primaryColor.name, if (darkTheme) Color("#d1d8e0") else Color("#4b7bec"))
            variable(secondaryColor.name, if (darkTheme) Color("#778ca3") else Color("#45aaf2"))
            variable(neutralTextColor.name, if (darkTheme) rgb(240, 240, 240) else Color.black)
            variable(primaryTextColor.name, if (darkTheme) Color.black else rgb(240, 240, 240))
            variable(secondaryTextColor.name, if (darkTheme) Color.white else rgb(240, 240, 240))
        }
    }

    companion object {
        /**
         * Background for [neutralColor] and [neutralTextColor]
         */
        val backgroundNeutralColor by variable<CSSColorValue>()
        /**
         * Background for [primaryColor] and [primaryTextColor]
         */
        val backgroundPrimaryColor by variable<CSSColorValue>()
        /**
         * Background for [secondaryColor] and [secondaryTextColor]
         */
        val backgroundSecondaryColor by variable<CSSColorValue>()
        /**
         * Background for [primaryTextColor]
         */
        val neutralColor by variable<CSSColorValue>()
        /**
         * Background for [primaryTextColor]
         */
        val primaryColor by variable<CSSColorValue>()
        /**
         * Background for [secondaryTextColor]
         */
        val secondaryColor by variable<CSSColorValue>()
        val primaryTextColor by variable<CSSColorValue>()
        val neutralTextColor by variable<CSSColorValue>()
        val secondaryTextColor by variable<CSSColorValue>()

        val DARK = ThemeStyleSheet(true)
        val LIGHT = ThemeStyleSheet(false)
    }
}
