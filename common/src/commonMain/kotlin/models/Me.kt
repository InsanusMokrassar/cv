package dev.inmo.resume.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Me(
    val name: String,
    val birthday: String,
    val phoneText: String,
    val phoneNumber: String,
    val email: String,
    val additional: List<Pair<String, String>> = emptyList()
)
