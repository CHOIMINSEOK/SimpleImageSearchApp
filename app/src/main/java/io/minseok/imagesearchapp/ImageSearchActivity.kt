package io.minseok.imagesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import io.minseok.imagesearchapp.base.BaseActivity
import io.minseok.imagesearchapp.databinding.ActivityImageSearchBinding
import kotlinx.android.synthetic.main.activity_image_search.*

class ImageSearchActivity : BaseActivity<ActivityImageSearchBinding>() {

    override val layoutResId = R.layout.activity_image_search
    private val imageSearchViewModel = ImageDataViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.imageDataViewModel = imageSearchViewModel

        et_search.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                imageSearchViewModel.updateInput(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })
    }
}
