package io.minseok.imagesearchapp.support.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
}