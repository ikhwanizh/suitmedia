package com.ikhwanizh.suitmediatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhwanizh.suitmediatest.Repository
import com.ikhwanizh.suitmediatest.data.model.ApiResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class ThirdActivityViewModel(private val repository: Repository): ViewModel() {
    private val getUsers = MutableLiveData<Response<ApiResponse>>()
    val observeUsers: LiveData<Response<ApiResponse>> = getUsers

    fun getUsers(){
        viewModelScope.launch {
            try {
                val result = repository.getUsers()
                getUsers.postValue(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}