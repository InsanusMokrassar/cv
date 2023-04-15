package dev.inmo.resume.common.models

import dev.inmo.kslog.common.TagLogger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

@Serializable
data class Github(
    val username: String,
    val server: String = "https://api.github.com"
) {
    @Transient
    val Log = TagLogger("Github.$username")

    @Serializable
    data class License(
        val key: String,
        val name: String
    )
    @Serializable
    data class Repository(
        val name: String,
        val title: String? = null,
        val description: String? = null,
        @SerialName("html_url")
        val webUrl: String? = null,
        @SerialName("stargazers_count")
        val stars: Int? = null,
        val language: String? = null,
        val license: License? = null,
        val topics: List<String> = emptyList()
    )

    companion object {
        val JSON = Json {
            ignoreUnknownKeys = true
        }
        val RepositoriesSerializer = ListSerializer(Repository.serializer())
    }
}

expect suspend fun Github.getRepositories(): List<Github.Repository>
