package dev.inmo.resume.client.css

import dev.inmo.resume.client.utils.ExtraSmallScreen
import dev.inmo.resume.client.utils.LargeScreen
import dev.inmo.resume.client.utils.MediumScreen
import dev.inmo.resume.client.utils.SmallScreen
import dev.inmo.resume.client.utils.styleOn
import org.jetbrains.compose.web.css.*

object RootAnchorStyleSheet : StyleSheet() {
    private val largeWidth = 1024.px
    private val mediumWidth = 768.px
    private val smallWidth = 620.px
    private val extraSmallWidth = 480.px
    private fun CSSBuilder.includeCommonSizesPoints() {
        styleOn(LargeScreen) {
            width(largeWidth)
        }
        styleOn(MediumScreen) {
            width(mediumWidth)
        }
    }
    val center by style {
        property("margin", "0 auto")
        includeCommonSizesPoints()
        styleOn(SmallScreen) {
            width(smallWidth)
        }
        styleOn(ExtraSmallScreen) {
            property("width", "unset")
            maxWidth(extraSmallWidth)
        }
    }
    val header by style {
        property("margin", "0 auto")
        includeCommonSizesPoints()
        styleOn(SmallScreen) {
            margin(0.px, 16.px)
        }
        styleOn(ExtraSmallScreen) {
            margin(0.px)
        }
    }
}
