package io.minseok.imagesearchapp.app

import io.minseok.imagesearchapp.domain.ImageRepository
import io.minseok.imagesearchapp.data.ImageRepositoryImpl
import io.minseok.imagesearchapp.presentation.viewmodel.ImageDataViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val smoothyCommonModule = module {

    single { ImageRepositoryImpl(get(), get(), get()) as ImageRepository }

    viewModel {
        ImageDataViewModel(
            get()
        )
    }
}