package dev.inmo.resume.client.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val title: String,
    val link: String,
    val description: String? = null
)
