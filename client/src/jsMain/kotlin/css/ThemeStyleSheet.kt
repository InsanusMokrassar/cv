package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.*

class ThemeStyleSheet(darkTheme: Boolean) : StyleSheet() {
    init {
        root style {
            variable(backgroundPrimaryColor.name, if (darkTheme) rgb(0, 6, 17) else rgb(197, 220, 243))
            variable(backgroundSecondaryColor.name, if (darkTheme) rgb(0, 34, 62) else rgb(95, 148, 200))
            variable(primaryTextColor.name, if (darkTheme) Color.white else Color.black)
            variable(secondaryTextColor.name, if (darkTheme) Color.white else Color.white)
        }
    }

    companion object {
        val backgroundPrimaryColor by variable<CSSColorValue>()
        val backgroundSecondaryColor by variable<CSSColorValue>()
        val primaryColor by variable<CSSColorValue>()
        val secondaryColor by variable<CSSColorValue>()
        val primaryTextColor by variable<CSSColorValue>()
        val secondaryTextColor by variable<CSSColorValue>()

        val DARK = ThemeStyleSheet(true)
        val LIGHT = ThemeStyleSheet(false)
    }
}
