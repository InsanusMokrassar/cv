package dev.inmo.resume.client.css

import dev.inmo.resume.client.utils.onLargeScreen
import dev.inmo.resume.client.utils.styleOnExtraSmallScreen
import dev.inmo.resume.client.utils.styleOnLargeScreen
import dev.inmo.resume.client.utils.styleOnMediumScreen
import dev.inmo.resume.client.utils.styleOnSmallScreen
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMinWidth
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width

object RootAnchorStyleSheet : StyleSheet() {
    val center by style {
        property("margin", "0 auto")
        styleOnLargeScreen {
            width(768.px)
        }
        styleOnMediumScreen {
            width(640.px)
        }
        styleOnSmallScreen {
            width(480.px)
        }
        styleOnExtraSmallScreen {
            width(320.px)
        }
    }
}
