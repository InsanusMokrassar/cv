package dev.inmo.resume.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val title: String,
    val link: String,
    val description: String? = null
)
