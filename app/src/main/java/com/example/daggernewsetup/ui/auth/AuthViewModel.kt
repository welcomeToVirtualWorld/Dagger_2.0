package com.example.daggernewsetup.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggernewsetup.business.interactor.CheckUserExist
import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.network.auth.AuthApi
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    authApi: AuthApi,
    val sessionStoreManager: SessionStoreManager,
    val checkUserExist: CheckUserExist
) : ViewModel() {


    val _loading by lazy {
        MutableLiveData(false)
    }

    val loading: LiveData<Boolean>
        get() = _loading


    private val _authUser = MutableLiveData<UserItem>()
    val authUser:LiveData<UserItem>
        get() {
            return _authUser
        }

    init {
        if (authApi == null){
            println("nullll:->")
        }else{
            println("not nullll:->")
        }
        println("working:::->")

    }


    fun getUSer(id:Int){
        viewModelScope.launch {
            checkUserExist.invoke(id).collectLatest {
                when(it){
                    is Resource.Loading ->{
                        _loading.postValue(true)
                    }
                    is Resource.Success ->{
                        sessionStoreManager.setIsUserLoogedIn(true)
                        _loading.postValue(false)
                        _authUser.postValue(it.data)
                    }
                    is Resource.Error ->{
                        println("message"+it.throwable.message)
                        _loading.postValue(false)
                    }
                }

            }
        }

    }


}