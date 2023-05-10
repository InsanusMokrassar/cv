package dev.inmo.resume.client.utils

var darkModeSetting: Boolean
    get() = getSetting("dm") != null
    set(value) {
        if (value) {
            setSetting("dm", "true")
        } else {
            setSetting("dm", null)
        }
    }
