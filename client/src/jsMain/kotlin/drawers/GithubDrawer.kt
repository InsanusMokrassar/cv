package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import dev.inmo.resume.client.css.ThemeStyleSheet
import dev.inmo.resume.client.utils.Drawer
import dev.inmo.resume.common.models.Github
import dev.inmo.resume.common.models.getRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

class GithubDrawer(private val github: Github, scope: CoroutineScope) : Drawer {
    private val repositoriesState = mutableStateListOf<Github.Repository>()
    private val requestJob = scope.launch {
        repositoriesState.addAll(
            github.getRepositories().sortedByDescending { it.stars ?: 0 }
        )
    }

    private object GHStyles : StyleSheet() {
        val commonContainer by style {
            display(DisplayStyle.Grid)
            gridTemplateColumns("1fr 1fr")
            columnGap(16.px)
            rowGap(16.px)
        }
        @OptIn(ExperimentalComposeWebApi::class)
        val itemContainer by style {
            borderRadius(4.px)
            border {
                color(ThemeStyleSheet.secondaryTextColor.value())
                width(2.px)
                style(LineStyle.Solid)
            }
            padding(4.px, 8.px)
            display(DisplayStyle.Grid)
            gridTemplateColumns("1fr")
            gridTemplateRows("auto 1fr auto")
            textDecoration("unset")
            property("box-shadow", "0")
            transitions {
                properties("box-shadow", "transform") {
                    duration(0.1.s)
                    timingFunction(AnimationTimingFunction.Linear)
                }
            }

            hover(self) style {
                property("box-shadow", "0 0 12px")
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

    @Composable
    override fun invoke() {
        Style(GHStyles)

        Div({ classes(GHStyles.commonContainer) }) {
            repositoriesState.forEach {
                A(
                    it.webUrl,
                    {
                        classes(GHStyles.itemContainer)
                    }
                ) {
                    (it.title ?: it.name).let { H4 { Text(it) } }
                    P { it.description ?.let { description -> Text(description) } }

                    Div({ classes(GHStyles.linksIcons) }) {
                        it.stars ?.takeIf { it > 0 } ?.let { start ->
                            Div({ classes(GHStyles.linkIcon) }) { Text("☆$start") }
                        }
                    }
                }
            }
        }
    }
}
