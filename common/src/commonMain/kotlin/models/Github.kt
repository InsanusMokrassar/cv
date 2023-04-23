package dev.inmo.resume.common.models

import dev.inmo.kslog.common.TagLogger
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlin.jvm.JvmInline

@Serializable
data class Github(
    val username: String,
    val server: String = "https://api.github.com",
    val count: Int? = null,
    @Serializable(SortOrder.Companion::class)
    val sort: SortOrder = SortOrder.ASC,
    @Serializable(SortBy.Companion::class)
    val sortBy: SortBy = SortBy.STARS
) {
    @Transient
    val Log = TagLogger("Github.$username")
    sealed interface SortOrder {
        val title: String
        @Serializable
        object ASC : SortOrder {
            override val title: String
                get() = "asc"
        }
        @Serializable
        object DESC : SortOrder {
            override val title: String
                get() = "desc"
        }

        @Serializable
        @JvmInline
        private value class SortOrderRaw(val title: String) {
            fun asSortOrder(): SortOrder = when (title) {
                DESC.title -> DESC
                else -> ASC
            }
        }
        companion object : KSerializer<SortOrder> {
            override val descriptor: SerialDescriptor = SortOrderRaw.serializer().descriptor

            override fun deserialize(decoder: Decoder): SortOrder {
                return SortOrderRaw.serializer().deserialize(decoder).asSortOrder()
            }

            override fun serialize(encoder: Encoder, value: SortOrder) {
                SortOrderRaw.serializer().serialize(encoder, SortOrderRaw(value.title))
            }

        }
    }
    sealed interface SortBy {
        val title: String
        @Serializable
        object STARS : SortBy {
            override val title: String
                get() = "start"
        }
        @Serializable
        object TITLE : SortBy {
            override val title: String
                get() = "title"
        }
        @Serializable
        object DATE_CHANGED : SortBy {
            override val title: String
                get() = "date"
        }

        @Serializable
        @JvmInline
        private value class SortByRaw(val title: String) {
            fun asSortBy(): SortBy = when (title) {
                TITLE.title -> TITLE
                DATE_CHANGED.title -> DATE_CHANGED
                else -> STARS
            }
        }
        companion object : KSerializer<SortBy> {
            override val descriptor: SerialDescriptor = SortByRaw.serializer().descriptor

            override fun deserialize(decoder: Decoder): SortBy {
                return SortByRaw.serializer().deserialize(decoder).asSortBy()
            }

            override fun serialize(encoder: Encoder, value: SortBy) {
                SortByRaw.serializer().serialize(encoder, SortByRaw(value.title))
            }

        }
    }

    @Serializable
    data class License(
        val key: String,
        val name: String
    )
    @Serializable
    @JvmInline
    value class DateTime(
        val string: String
    ) : Comparable<DateTime> {
        override fun compareTo(other: DateTime): Int = string.compareTo(other.string)
        companion object {
            val defaultZero = Github.DateTime("0-01-26T19:14:43Z")
        }
    }
    @Serializable
    data class Repository(
        val name: String,
        val title: String? = null,
        val description: String? = null,
        @SerialName("html_url")
        val webUrl: String? = null,
        @SerialName("stargazers_count")
        val stars: Int? = null,
        @SerialName("open_issues_count")
        val openIssues: Int? = null,
        @SerialName("forks_count")
        val forks: Int? = null,
        val language: String? = null,
        val license: License? = null,
        val topics: List<String> = emptyList(),
        @SerialName("pushed_at")
        val pushedAt: DateTime? = null,
        @SerialName("created_at")
        val createdAt: DateTime? = null,
        @SerialName("updated_at")
        val updatedAt: DateTime? = null
    )

    companion object {
        val JSON = Json {
            ignoreUnknownKeys = true
        }
        val RepositoriesSerializer = ListSerializer(Repository.serializer())
    }
}

expect suspend fun Github.getRepositories(): List<Github.Repository>
