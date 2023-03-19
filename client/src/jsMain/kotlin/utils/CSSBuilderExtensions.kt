package dev.inmo.resume.client.utils

import org.jetbrains.compose.web.css.CSSBuilder
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.GenericStyleSheetBuilder
import org.jetbrains.compose.web.css.and
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.mediaMinWidth
import org.jetbrains.compose.web.css.px

sealed interface MediaQueryBuilder {
    val min: CSSUnitValue?
    val max: CSSUnitValue?

    object Large : MediaQueryBuilder {
        override val min: CSSUnitValue = 1201.px
        override val max: CSSUnitValue? = null

        override fun GenericStyleSheetBuilder<CSSBuilder>.mediaQuery() = mediaMinWidth(min)
    }
    object Medium : MediaQueryBuilder {
        override val min: CSSUnitValue = 961.px
        override val max: CSSUnitValue = 1200.px

        override fun GenericStyleSheetBuilder<CSSBuilder>.mediaQuery() = mediaMinWidth(min).and(mediaMaxWidth(max))
    }
    object Small : MediaQueryBuilder {
        override val min: CSSUnitValue = 641.px
        override val max: CSSUnitValue = 960.px

        override fun GenericStyleSheetBuilder<CSSBuilder>.mediaQuery() = mediaMinWidth(min).and(mediaMaxWidth(max))
    }
    object ExtraSmall : MediaQueryBuilder {
        override val min: CSSUnitValue? = null
        override val max: CSSUnitValue = 640.px

        override fun GenericStyleSheetBuilder<CSSBuilder>.mediaQuery() = mediaMaxWidth(max)
    }

    fun GenericStyleSheetBuilder<CSSBuilder>.mediaQuery(): CSSMediaQuery
}

val GenericStyleSheetBuilder<CSSBuilder>.LargeScreen
    get() = with (MediaQueryBuilder.Large) { mediaQuery() }

val GenericStyleSheetBuilder<CSSBuilder>.MediumScreen
    get() = with (MediaQueryBuilder.Medium) { mediaQuery() }

val GenericStyleSheetBuilder<CSSBuilder>.SmallScreen
    get() = with (MediaQueryBuilder.Small) { mediaQuery() }

val GenericStyleSheetBuilder<CSSBuilder>.ExtraSmallScreen
    get() = with (MediaQueryBuilder.ExtraSmall) { mediaQuery() }

private fun CSSMediaQuery.Combinable.toAtomics(): Array<CSSMediaQuery.Atomic> = when (this) {
    is CSSMediaQuery.And -> mediaList.toTypedArray()
    is CSSMediaQuery.Atomic -> listOf(this).toTypedArray()
    else -> arrayOf(CSSMediaQuery.Raw(toString()))
}
infix fun CSSMediaQuery.Combinable.and(other: CSSMediaQuery.Combinable) = CSSMediaQuery.And(
    mutableListOf(
        *toAtomics(),
        *other.toAtomics(),
    )
)
infix fun CSSMediaQuery.or(other: CSSMediaQuery) = CSSMediaQuery.Combine(
    mutableListOf(
        this,
        other
    )
)

fun CSSBuilder.on(
    query: CSSMediaQuery,
    builder: GenericStyleSheetBuilder<CSSBuilder>.() -> Unit
) {
    media(query) {
        builder()
    }
}

fun CSSBuilder.styleOn(
    query: CSSMediaQuery,
    builder: CSSBuilder.() -> Unit
) {
    on(query) {
        self style {
            builder()
        }
    }
}
