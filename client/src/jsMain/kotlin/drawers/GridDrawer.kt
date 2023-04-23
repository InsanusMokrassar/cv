package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.css.GridElementsStyleSheet
import dev.inmo.resume.client.utils.Drawer
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLParagraphElement

class GridDrawer(
    private val elements: Iterable<Element>
) : Drawer {
    data class Element(
        val url: String?,
        val title: String,
        val description: String?,
        val icons: List<String>
    ) {
        constructor(
            url: String?,
            title: String,
            description: String?,
            vararg icons: String?
        ) : this(
            url, title, description, icons.filterNotNull()
        )
    }

    @Composable
    override fun invoke() {
        DrawGrid(elements)
    }

    companion object {
        @Composable
        fun DrawElement(
            link: @Composable () -> String?,
            titleDrawer: @Composable ElementScope<HTMLAnchorElement>.() -> Unit,
            descriptionDrawer: @Composable ElementScope<HTMLParagraphElement>.() -> Unit = {},
            iconsDrawers: Iterable<@Composable ElementScope<HTMLDivElement>.() -> Unit> = emptyList(),
        ) {
            val href = link()
            A(
                href,
                {
                    classes(GridElementsStyleSheet.itemContainer)
                    if (href != null) {
                        classes(GridElementsStyleSheet.itemContainerHoverable)
                    }
                }
            ) {
                titleDrawer()
                P {
                    descriptionDrawer()
                }

                Div({ classes(GridElementsStyleSheet.linksIcons) }) {
                    iconsDrawers.forEach {
                        Div({ classes(GridElementsStyleSheet.linkIcon) }) { it() }
                    }
                }
            }
        }
        @Composable
        fun DrawElement(
            link: @Composable () -> String?,
            titleDrawer: @Composable ElementScope<HTMLAnchorElement>.() -> Unit,
            descriptionDrawer: @Composable ElementScope<HTMLParagraphElement>.() -> Unit = {},
            vararg iconsDrawers: @Composable ElementScope<HTMLDivElement>.() -> Unit,
        ) = DrawElement(link, titleDrawer, descriptionDrawer, iconsDrawers.toList())

        @Composable
        fun DrawGrid(
            drawer: @Composable ElementScope<HTMLDivElement>.() -> Unit
        ){
            Div({ classes(GridElementsStyleSheet.commonContainer) }) {
                drawer()
            }
        }
        @Composable
        fun <T> DrawGrid(
            data: Iterable<T>,
            link: @Composable (T) -> String?,
            titleDrawer: @Composable ElementScope<HTMLAnchorElement>.(T) -> Unit,
            descriptionDrawer: @Composable ElementScope<HTMLParagraphElement>.(T) -> Unit = {},
            iconsDrawers: Iterable<@Composable ElementScope<HTMLDivElement>.(T) -> Unit> = emptyList(),
        ) {
            DrawGrid {
                data.forEach { element ->
                    DrawElement(
                        { link(element) },
                        { titleDrawer(element) },
                        { descriptionDrawer(element) },
                        iconsDrawers.map { { it(element) } },
                    )
                }
            }
        }
        @Composable
        fun <T> DrawGrid(
            data: Iterable<T>,
            link: @Composable (T) -> String?,
            titleDrawer: @Composable ElementScope<HTMLAnchorElement>.(T) -> Unit,
            descriptionDrawer: @Composable ElementScope<HTMLParagraphElement>.(T) -> Unit = {},
            vararg iconsDrawers: @Composable ElementScope<HTMLDivElement>.(T) -> Unit ,
        ) = DrawGrid(data, link, titleDrawer, descriptionDrawer, iconsDrawers.toList())
        @Composable
        fun DrawGrid(
            data: Iterable<Element>
        ) = DrawGrid(
            data,
            { it.url },
            { H4 { Text(it.title) } },
            { it.description ?.let { description -> Text(description) } },
            (0 until (data.maxOfOrNull { it.icons.size } ?: 0)).map { i ->
                @Composable { it.icons.getOrNull(i) ?.let { iconText -> Text(iconText) } }
            }
        )
    }
}
