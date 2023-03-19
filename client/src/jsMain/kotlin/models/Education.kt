package dev.inmo.resume.client.models

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val grade: String,
    val university: String,
    val major: String,
    val yearOfGraduation: String,
    val additional: List<Pair<String, String>> = emptyList()
)
