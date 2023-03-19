package dev.inmo.resume.client.utils

import androidx.compose.runtime.Composable

fun interface Drawer {
    @Composable
    operator fun invoke()
}
