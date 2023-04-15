package dev.inmo.resume.common.models

import dev.inmo.kslog.common.e
import kotlinx.browser.window
import kotlinx.coroutines.await


actual suspend fun Github.getRepositories(): List<Github.Repository> {
    val result = mutableListOf<Github.Repository>()
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
            result.addAll(requestResult.getOrThrow())
        }
        page++
    } while (requestResult.isSuccess && requestResult.getOrThrow().isNotEmpty())

    return result.toList()

}
