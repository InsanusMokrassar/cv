package dev.inmo.resume.common.models

import dev.inmo.kslog.common.e
import kotlinx.browser.window
import kotlinx.coroutines.await


actual suspend fun Github.getRepositories(): List<Github.Repository> {
    val repositories = mutableListOf<Github.Repository>()
    var page = 1

    do {
        val requestResult = runCatching {
            val responseText = window.fetch(
                "$server/users/$username/repos?per_page=100&page=$page"
            ).await().text().await()

            Github.JSON.decodeFromString(Github.RepositoriesSerializer, responseText)
        }.onFailure {
            Log.e(it) {
                "Unable to get user repos"
            }
        }

        if (requestResult.isSuccess) {
            repositories.addAll(requestResult.getOrThrow())
        }
        page++
    } while (requestResult.isSuccess && requestResult.getOrThrow().isNotEmpty())

    val sortByCallback: Comparator<Github.Repository> = when (sortBy) {
        Github.SortBy.DATE_CHANGED -> Comparator { a, b ->
            (a.pushedAt ?: Github.DateTime.defaultZero).compareTo(b.pushedAt ?: Github.DateTime.defaultZero)
        }
        Github.SortBy.STARS -> Comparator { a, b ->
            (a.stars ?: 0).compareTo(b.stars ?: 0)
        }
        Github.SortBy.TITLE -> Comparator { a, b ->
            (a.title ?: a.name).compareTo(b.title ?: b.name)
        }
    }
    val sortedRepositories = when (sort) {
        Github.SortOrder.ASC -> repositories.sortedWith(sortByCallback)
        Github.SortOrder.DESC -> repositories.sortedWith(sortByCallback.reversed())
    }

    return if (count != null) {
        sortedRepositories.take(count)
    } else {
        sortedRepositories
    }
}
