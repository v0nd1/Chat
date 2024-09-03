package com.vondi.chat.di

import com.vondi.chat.data.remote.MangoApi
import com.vondi.chat.ui.util.CountryNumber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): MangoApi{
        return builder
            .build()
            .create(MangoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://plannerok.ru/")
            .addConverterFactory(GsonConverterFactory.create())
    }

}