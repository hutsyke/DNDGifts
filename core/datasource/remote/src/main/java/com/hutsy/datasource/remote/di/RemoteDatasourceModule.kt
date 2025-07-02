package com.hutsy.datasource.remote.di

import com.hutsy.datasource.remote.util.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.dsl.module

val remoteDatasourceModule =
    module {
        single<HttpClient> {
            HttpClientFactory.create()
        }
    }