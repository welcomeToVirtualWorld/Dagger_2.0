package com.example.daggernewsetup.di

import android.app.Application
import com.example.daggernewsetup.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//singleton scope own bu Component once component dies all the dependency with singleton will die.
//service
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
AppModule::class,ActivityBuildersModule::class])
interface AppComponents : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponents
    }

}