package com.ikhwanizh.suitmediatest.di

import com.ikhwanizh.suitmediatest.viewmodel.ThirdActivityViewModel
import org.koin.dsl.module

val viewModelModule= module {
    single { ThirdActivityViewModel(get()) }
}