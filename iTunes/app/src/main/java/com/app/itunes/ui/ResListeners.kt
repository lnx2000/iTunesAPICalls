package com.app.itunes.ui

import com.app.itunes.data.entities.Song

interface ResListeners {
    fun onFailure(msg: String)

    fun onSuccess()
    fun processRV(songs: List<Song>, of: String)
}