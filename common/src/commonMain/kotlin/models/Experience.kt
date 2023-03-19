package dev.inmo.resume.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Experience(
    val position: String,
    val company: String,
    val companyLink: String?,
    val period: String,
    val location: String,
    val additional: List<Pair<String, String>> = emptyList()
)
