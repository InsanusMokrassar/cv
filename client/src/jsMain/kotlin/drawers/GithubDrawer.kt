package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import dev.inmo.resume.client.css.GridElementsStyleSheet
import dev.inmo.resume.client.css.ThemeStyleSheet
import dev.inmo.resume.client.utils.*
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
            github.getRepositories()
        )
    }

    @Composable
    override fun invoke() {
        GridDrawer.DrawGrid(
            repositoriesState.map {
                GridDrawer.Element(
                    it.webUrl,
                    it.title ?: it.name,
                    it.description,
                    it.stars ?.takeIf { it > 0 } ?.let { "☆$it" }
                )
            }
        )
    }
}
