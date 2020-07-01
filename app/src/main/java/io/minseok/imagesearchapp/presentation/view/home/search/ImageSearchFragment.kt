package io.minseok.imagesearchapp.presentation.view.home.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.databinding.FragmentImageSearchBinding
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.presentation.view.base.BaseFragment
import io.minseok.imagesearchapp.presentation.view.detail.ImageDetailActivity
import io.minseok.imagesearchapp.presentation.view.home.common.ImageItemAdapter
import io.minseok.imagesearchapp.presentation.viewmodel.ImageDataViewModel
import kotlinx.android.synthetic.main.fragment_image_search.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ImageSearchFragment : BaseFragment<FragmentImageSearchBinding>() {

    override val layoutResId =
        R.layout.fragment_image_search
    private val imageDataViewModel: ImageDataViewModel by sharedViewModel()

    companion object {
        val DETAIL_URL = "detail_url"
    }

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
        list_images.adapter =
            ImageItemAdapter(
                this::handleAction
            )
        list_images.layoutManager = LinearLayoutManager(requireContext())

        et_search.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                imageDataViewModel.updateInput(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })
    }

    private fun handleAction(action: Action) {
        when(action) {
            is Action.GoDetail -> {
                startActivity(Intent(requireContext(), ImageDetailActivity::class.java)
                    .putExtra(DETAIL_URL, action.url))
            }

            is Action.SetFavorite -> {
                imageDataViewModel.setFavorite(action.image, action.favorate)
            }
        }
    }
}

sealed class Action {
    class GoDetail(val url: String) : Action()
    class SetFavorite(val image: Image, val favorate: Boolean) : Action()
}
