package com.example.daggernewsetup

import com.example.daggernewsetup.di.DaggerAppComponents
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
//Client

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponents.builder().application(this).build()
    }
}