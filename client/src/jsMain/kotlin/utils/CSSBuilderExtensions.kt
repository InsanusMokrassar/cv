package dev.inmo.resume.client.utils

import org.jetbrains.compose.web.css.CSSBuilder
import org.jetbrains.compose.web.css.GenericStyleSheetBuilder
import org.jetbrains.compose.web.css.and
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.mediaMinWidth
import org.jetbrains.compose.web.css.px

fun CSSBuilder.onLargeScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    media(mediaMinWidth(1201.px)) {
        builder()
    }
}

fun CSSBuilder.styleOnLargeScreen(
    builder: CSSBuilder.() -> Unit
) {
    onLargeScreen {
        self.style(builder)
    }
}

fun CSSBuilder.onMediumScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    media(mediaMaxWidth(1200.px).and(mediaMinWidth(961.px))) {
        builder()
    }
}

fun CSSBuilder.styleOnMediumScreen(
    builder: CSSBuilder.() -> Unit
) {
    onMediumScreen {
        self.style(builder)
    }
}

fun CSSBuilder.onSmallScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    media(mediaMaxWidth(960.px).and(mediaMinWidth(641.px))) {
        builder()
    }
}

fun CSSBuilder.styleOnSmallScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    onSmallScreen {
        self.style(builder)
    }
}

fun CSSBuilder.onExtraSmallScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    media(mediaMaxWidth(640.px)) {
        builder()
    }
}

fun CSSBuilder.styleOnExtraSmallScreen(
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    onExtraSmallScreen {
        self.style(builder)
    }
}
