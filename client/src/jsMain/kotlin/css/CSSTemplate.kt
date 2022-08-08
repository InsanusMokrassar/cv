package dev.inmo.resume.client.css

import org.jetbrains.compose.web.css.CSSBuilder

typealias CSSTemplate = CSSBuilder.() -> Unit
@Suppress("NOTHING_TO_INLINE")
inline fun CSSTemplate(noinline block: CSSTemplate) = block
