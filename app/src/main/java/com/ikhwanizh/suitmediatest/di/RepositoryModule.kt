package com.ikhwanizh.suitmediatest.di

import com.ikhwanizh.suitmediatest.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
}