package com.example.daggernewsetup.di

import android.app.Application
import android.app.Presentation
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggernewsetup.R
import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import com.example.daggernewsetup.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//any thing that will not change and remains entire lifecycle of Application add in this class e.g::Retrofit,Glide Instanse.
@Module
class AppModule {

    companion object{

        @Singleton
        @Provides
        @JvmStatic
        fun provideRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun someString():String{
            return "this is a test string."
        }

        @Singleton
        @Provides
        @JvmStatic
        fun getIsApplicationNull(application:Application):Boolean{
            return application==null
        }


        @Singleton
        @JvmStatic
        @Provides
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

        }

        @Singleton
        @JvmStatic
        @Provides
        fun provideGlideInstance(application:Application,requestOptions: RequestOptions): RequestManager {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }

        @Singleton
        @JvmStatic
        @Provides
        fun gson():Gson{
            return GsonBuilder().create()
        }

        @Singleton
        @Provides
        fun dataStore(application: Application): DataStore<Preferences> =
            PreferenceDataStoreFactory.create(
                produceFile = {
                    application.preferencesDataStoreFile("Demo")
                }
            )

        @Singleton
        @Provides
        fun sessionStoreManager(gson: Gson,dataStore: DataStore<Preferences>):SessionStoreManager{
            return SessionStoreManager(dataStore,gson)
        }

        @Singleton
        @Provides
        fun someUser():UserItem{
            return UserItem("nnde",1,"djhdjd","ydgeg")
        }
    }

}