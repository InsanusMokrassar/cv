package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display

object AnchorStyleSheet : StyleSheet() {
    val container by style {
        CommonStyleSheet.Width.expand(this)
    }
    val header by style {
        CommonStyleSheet.Width.expand(this)
    }
    val middle by style {
        display(DisplayStyle.Flex)
        CommonStyleSheet.Width.expand(this)
    }
    val leftSide by style {
    }
    val center by style {
        CommonStyleSheet.Width.expand(this)
    }
    val rightSide by style {
    }
    val footer by style {
        CommonStyleSheet.Width.expand(this)
    }
}
