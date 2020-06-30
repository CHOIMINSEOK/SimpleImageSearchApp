package io.minseok.imagesearchapp.presentation.view.detail

import android.os.Bundle
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.databinding.ActivityImageDetailBinding
import io.minseok.imagesearchapp.presentation.view.base.BaseActivity
import io.minseok.imagesearchapp.presentation.view.home.search.ImageSearchFragment
import io.minseok.imagesearchapp.support.load

class ImageDetailActivity: BaseActivity<ActivityImageDetailBinding>() {
    override val layoutResId = R.layout.activity_image_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getStringExtra(ImageSearchFragment.DETAIL_URL)?.let {
            binding.image.load(it)
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}