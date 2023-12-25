package com.ikhwanizh.suitmediatest

import com.ikhwanizh.suitmediatest.data.service.ApiService

class Repository(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}