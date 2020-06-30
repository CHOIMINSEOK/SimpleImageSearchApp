package io.minseok.imagesearchapp.presentation.view.home.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.minseok.imagesearchapp.databinding.FragmentFavoriteBinding
import io.minseok.imagesearchapp.presentation.view.base.BaseFragment
import io.minseok.imagesearchapp.R

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>() {
    override val layoutResId: Int = R.layout.fragment_favorite

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}