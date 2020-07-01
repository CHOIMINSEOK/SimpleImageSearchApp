package io.minseok.imagesearchapp.app

import io.minseok.imagesearchapp.support.rx.AndroidSchedulerProvider
import io.minseok.imagesearchapp.support.rx.SchedulerProvider
import org.koin.dsl.module.module

val rxAppModule = module {
    single { AndroidSchedulerProvider() as SchedulerProvider }
}