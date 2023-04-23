package dev.inmo.resume.client.css

import dev.inmo.resume.client.utils.ExtraSmallScreen
import dev.inmo.resume.client.utils.SmallScreen
import dev.inmo.resume.client.utils.or
import dev.inmo.resume.client.utils.styleOn
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

object GridElementsStyleSheet : StyleSheet() {
    val commonContainer by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns("minmax(0, 1fr) minmax(0, 1fr)")
        columnGap(16.px)
        rowGap(16.px)

        styleOn(SmallScreen or ExtraSmallScreen) {
            gridTemplateColumns("minmax(0, 1fr)")
        }
    }
    @OptIn(ExperimentalComposeWebApi::class)
    val itemContainer by style {
        borderRadius(4.px)
        border {
            color(ThemeStyleSheet.neutralTextColor.value())
            width(1.px)
            style(LineStyle.Solid)
        }
        padding(4.px, 8.px)
        display(DisplayStyle.Grid)
        gridTemplateColumns("1fr")
        gridTemplateRows("auto 1fr auto")
        textDecoration("unset")
        property("box-shadow", "0")
        property("box-shadow", "0 0 2px")
        transitions {
            properties("box-shadow", "transform") {
                duration(0.1.s)
                timingFunction(AnimationTimingFunction.Linear)
            }
        }
    }
    @OptIn(ExperimentalComposeWebApi::class)
    val itemContainerHoverable by style {
        hover(self) style {
            property("box-shadow", "0 0 8px")
            transform {
                scale(1.01)
            }
        }
    }
    val linksIcons by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns("1fr 1fr 1fr")
    }
    val linkIcon by style {
        textAlign("center")
        padding(8.px)
    }
}
