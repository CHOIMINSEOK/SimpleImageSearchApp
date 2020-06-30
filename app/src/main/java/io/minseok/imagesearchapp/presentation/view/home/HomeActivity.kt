package io.minseok.imagesearchapp.presentation.view.home

import android.os.Bundle
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.databinding.ActivityHomeBinding
import io.minseok.imagesearchapp.presentation.view.base.BaseActivity
import io.minseok.imagesearchapp.presentation.view.home.favorite.FavoriteFragment
import io.minseok.imagesearchapp.presentation.view.home.search.ImageSearchFragment

class HomeActivity: BaseActivity<ActivityHomeBinding>() {
    override val layoutResId = R.layout.activity_home

    private val favoriteFragment = FavoriteFragment()
    private val imageSearchFragment = ImageSearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.apply {
            beginTransaction().add(R.id.fragment_container, favoriteFragment, "menu").hide(favoriteFragment).commit()
            beginTransaction().add(R.id.fragment_container, imageSearchFragment, "menu").show(imageSearchFragment).commit()
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_favorite -> {
                    supportFragmentManager.beginTransaction().hide(imageSearchFragment).show(favoriteFragment).commit()
                }
                R.id.action_search -> {
                    supportFragmentManager.beginTransaction().hide(favoriteFragment).show(imageSearchFragment).commit()
                }
                else -> Unit
            }

            true
        }

    }
}