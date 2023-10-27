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
        columnGap(Sizes.Paddings.medium)
        rowGap(Sizes.Paddings.medium)

        styleOn(SmallScreen or ExtraSmallScreen) {
            gridTemplateColumns("minmax(0, 1fr)")
        }

        padding(Sizes.Paddings.medium, Sizes.Paddings.none)
    }
    @OptIn(ExperimentalComposeWebApi::class)
    val itemContainer by style {
        borderRadius(Sizes.BorderRadius.medium)
        border {
            color(ThemeStyleSheet.neutralTextColor.value())
            width(Sizes.Border.xSmall)
            style(LineStyle.Solid)
        }
        padding(Sizes.Paddings.xSmall, Sizes.Paddings.small)
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
    val itemTitleContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        gap(Sizes.Paddings.small)
    }
    @OptIn(ExperimentalComposeWebApi::class)
    val itemTitleImg by style {
        property("object-fit", "contain")
        width(Sizes.ImgPreview.large)
        height(Sizes.ImgPreview.large)

        styleOn(ExtraSmallScreen) {
            maxWidth(Sizes.ImgPreview.medium)
            maxHeight(Sizes.ImgPreview.medium)
        }

        filter {
            dropShadow(offsetX = 2.px, offsetY = 2.px, blurRadius = 5.px, color = rgba(0, 0, 0, 0.4f))
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
        padding(Sizes.Paddings.small)
    }
}
