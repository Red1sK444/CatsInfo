package com.r3d1r4ph.catsinfo.feature.cats.details.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.r3d1r4ph.catsinfo.R
import com.r3d1r4ph.catsinfo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val CAT_ID = "Cat id key"
    }

    private val viewBinding by viewBinding(ActivityDetailsBinding::bind, R.id.rootLayout)
    private val viewModel by viewModels<DetailsViewModel> {
        DetailsViewModelFactory(
            application,
            intent.getStringExtra(CAT_ID) ?: ""
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setObserver()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        viewBinding.detailsButton.setOnClickListener {
            finish()
        }
    }

    private fun setObserver() {
        viewModel.catImage.observe(this, ::bindImage)
    }

    private fun bindImage(url: String) {
        viewBinding.detailsImageView.load(url)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCatById()
    }
}