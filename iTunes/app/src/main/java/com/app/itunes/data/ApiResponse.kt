package com.app.itunes.data

import com.app.itunes.data.entities.Song

data class ApiResponse(
    var resultCount: Int,
    var results: List<Song>

)