package com.example.daggernewsetup.ui.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.daggernewsetup.business.interactor.GetAllPosts
import com.example.daggernewsetup.model.Posts
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.network.main.MainApi
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostViewModel @Inject constructor(
    mainApi: MainApi,
    sessionStoreManager: SessionStoreManager,
    val getAllPosts: GetAllPosts
): ViewModel() {

    private val _data = MutableLiveData<List<Posts>>()
    val data:LiveData<List<Posts>>
        get() = _data

    init {
        println("post fragment is working....")
    }

    fun getListOfPost(){
        viewModelScope.launch {
            getAllPosts.invoke().collectLatest {
                when(it){
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        _data.postValue(it.data?: listOf())
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }

    }
}