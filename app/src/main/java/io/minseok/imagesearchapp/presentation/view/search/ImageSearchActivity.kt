package io.minseok.imagesearchapp.presentation.view.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.presentation.view.base.BaseActivity
import io.minseok.imagesearchapp.databinding.ActivityImageSearchBinding
import io.minseok.imagesearchapp.presentation.viewmodel.ImageDataViewModel
import kotlinx.android.synthetic.main.activity_image_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImageSearchActivity : BaseActivity<ActivityImageSearchBinding>() {

    override val layoutResId =
        R.layout.activity_image_search
    private val imageSearchViewModel: ImageDataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.imageDataViewModel = imageSearchViewModel

        initViews()
    }

    fun initViews() {
        list_images.adapter =  ImageItemAdapter()
        list_images.layoutManager = LinearLayoutManager(applicationContext)


        et_search.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                imageSearchViewModel.updateInput(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })
    }
}
