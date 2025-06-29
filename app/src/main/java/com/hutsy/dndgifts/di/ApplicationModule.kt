package com.hutsy.dndgifts.di

import com.hutsy.dndgifts.DnDGiftsApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val applicationModule =
    module {
        single<CoroutineScope> { (androidApplication() as DnDGiftsApp).applicationScope }
    }