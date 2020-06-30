package io.minseok.imagesearchapp.app

import io.minseok.imagesearchapp.domain.repository.ImageRepository
import io.minseok.imagesearchapp.domain.repository.ImageRepositoryImpl
import io.minseok.imagesearchapp.presentation.ImageDataViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val smoothyCommonModule = module {

    single { ImageRepositoryImpl(get()) as ImageRepository}

    viewModel { ImageDataViewModel(get()) }
}