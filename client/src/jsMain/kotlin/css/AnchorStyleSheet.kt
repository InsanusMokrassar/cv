package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.StyleSheet

object AnchorStyleSheet : StyleSheet() {
    val container by style {
        CommonStyleSheet.Width.expand(this)
    }
    val header by style {
        CommonStyleSheet.Width.expand(this)
    }
    val middle by style {
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
