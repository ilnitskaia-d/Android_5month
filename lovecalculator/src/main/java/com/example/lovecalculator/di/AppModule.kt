package com.example.lovecalculator.di

import com.example.lovecalculator.MainPresenter
import com.example.lovecalculator.model.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi() : LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)

    }

    @Provides
    fun providePresenter(): MainPresenter {
        return MainPresenter(provideApi())
    }
}