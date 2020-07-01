package io.minseok.imagesearchapp.presentation.view.home.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.minseok.imagesearchapp.databinding.FragmentFavoriteBinding
import io.minseok.imagesearchapp.presentation.view.base.BaseFragment
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.presentation.view.home.common.ImageItemAdapter
import io.minseok.imagesearchapp.presentation.view.home.search.Action
import io.minseok.imagesearchapp.presentation.viewmodel.ImageDataViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>() {
    override val layoutResId: Int = R.layout.fragment_favorite
    private val imageDataViewModel: ImageDataViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.imageDataViewModel = imageDataViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.listImages.adapter =
            ImageItemAdapter(
                this::handleAction
            )
        binding.listImages.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun handleAction(action: Action) {
        when(action) {
            is Action.GoDetail -> { }
            is Action.SetFavorite -> {
                imageDataViewModel.setFavorite(action.image, action.favorate)
            }
        }
    }
}