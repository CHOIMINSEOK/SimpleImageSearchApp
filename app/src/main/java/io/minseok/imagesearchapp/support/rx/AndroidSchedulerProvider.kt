package io.minseok.imagesearchapp.support.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class AndroidSchedulerProvider : SchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
}