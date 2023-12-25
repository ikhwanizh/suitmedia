package com.ikhwanizh.suitmediatest.data.service

import com.ikhwanizh.suitmediatest.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ) : Response<ApiResponse>
}