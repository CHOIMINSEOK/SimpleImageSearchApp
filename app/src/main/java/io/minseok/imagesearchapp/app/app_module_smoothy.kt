package io.minseok.imagesearchapp.app

import io.minseok.imagesearchapp.presentation.ImageDataViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val smoothyCommonModule = module {
    viewModel { ImageDataViewModel(get()) }
}