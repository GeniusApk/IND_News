package com.geniusapk.indnews.repo

import com.geniusapk.indnews.network.ApiProvider
import com.geniusapk.indnews.network.NewsModel
import retrofit2.Response

class Repo {
    suspend fun newProvider(category: String?): Response<NewsModel>{
        return ApiProvider.providerApi().getNewsFromService(category = category)

    }
}