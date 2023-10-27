package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.CSSpxValue
import org.jetbrains.compose.web.css.px

sealed interface Sizes {
    val none: CSSpxValue
        get() = 0.px
    val xSmall: CSSpxValue
    val small: CSSpxValue
    val medium: CSSpxValue
    val large: CSSpxValue
    val xLarge: CSSpxValue

    data object Paddings : Sizes {
        override val xSmall: CSSpxValue = 4.px
        override val small: CSSpxValue = 8.px
        override val medium: CSSpxValue = 12.px
        override val large: CSSpxValue = 18.px
        override val xLarge: CSSpxValue = 24.px
    }

    data object ImgPreview : Sizes {
        override val xSmall: CSSpxValue = 8.px
        override val small: CSSpxValue = 16.px
        override val medium: CSSpxValue = 32.px
        override val large: CSSpxValue = 64.px
        override val xLarge: CSSpxValue = 128.px
    }

    data object BorderRadius : Sizes {
        override val xSmall: CSSpxValue = 1.px
        override val small: CSSpxValue = 2.px
        override val medium: CSSpxValue = 4.px
        override val large: CSSpxValue = 6.px
        override val xLarge: CSSpxValue = 8.px
    }

    data object Border : Sizes {
        override val xSmall: CSSpxValue = 1.px
        override val small: CSSpxValue = 2.px
        override val medium: CSSpxValue = 3.px
        override val large: CSSpxValue = 4.px
        override val xLarge: CSSpxValue = 6.px
    }
}