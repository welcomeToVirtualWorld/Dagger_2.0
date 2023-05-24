package com.example.daggernewsetup.ui.main

import androidx.lifecycle.ViewModel
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val sessionStoreManager: SessionStoreManager
):ViewModel() {

    init {
        println("MainViewModel:::->")
    }
}