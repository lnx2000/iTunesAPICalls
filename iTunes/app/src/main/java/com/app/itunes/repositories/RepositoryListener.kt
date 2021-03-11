package com.app.itunes.repositories

import com.app.itunes.data.ApiResponse

interface RepositoryListener {
    fun onSuccess(res: ApiResponse, of: String)
}