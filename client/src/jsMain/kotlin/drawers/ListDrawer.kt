package dev.inmo.resume.client.drawers

import androidx.compose.runtime.Composable
import dev.inmo.resume.client.utils.Drawer

class ListDrawer(
    private val drawers: List<Drawer>
) : Drawer {
    @Composable
    override fun invoke() {
        drawers.forEach {
            it()
        }
    }
}
