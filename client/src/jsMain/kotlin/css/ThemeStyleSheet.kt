package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.variable

class ThemeStyleSheet(darkTheme: Boolean) : StyleSheet() {
    init {
        root style {
            variable(backgroundNeutralColor.name, if (darkTheme) rgb(40, 41, 35) else rgb(240, 240, 240))
            variable(backgroundPrimaryColor.name, if (darkTheme) rgb(57, 48, 83) else rgb(142, 167, 233))
            variable(backgroundSecondaryColor.name, if (darkTheme) rgb(24, 18, 43) else rgb(95, 148, 200))
            variable(neutralColor.name, if (darkTheme) rgb(99, 89, 133) else rgb(255, 242, 242))
            variable(primaryColor.name, if (darkTheme) rgb(99, 89, 133) else rgb(255, 242, 242))
            variable(secondaryColor.name, if (darkTheme) rgb(68, 60, 104) else rgb(229, 224, 255))
            variable(neutralTextColor.name, if (darkTheme) Color.white else Color.black)
            variable(primaryTextColor.name, if (darkTheme) Color.white else Color.black)
            variable(secondaryTextColor.name, if (darkTheme) Color.white else Color.black)
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
