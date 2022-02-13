package com.r3d1r4ph.catsinfo.feature.cats.list.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.r3d1r4ph.catsinfo.R
import com.r3d1r4ph.catsinfo.databinding.ActivityListBinding
import com.r3d1r4ph.catsinfo.feature.cats.details.presentation.DetailsActivity
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem
import com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler.CatItemDecoration
import com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler.CatPagingAdapter

class ListActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(ActivityListBinding::bind, R.id.rootLayout)
    private val viewModel by viewModels<ListViewModel> {
        ListViewModelFactory(application)
    }
    private val pagingAdapter = CatPagingAdapter {
        viewModel.openDetailsScreen(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        configureRecycler()
        setObservers()
    }

    private fun configureRecycler() {
        viewBinding.listRecyclerView.apply {
            layoutManager =
                GridLayoutManager(this@ListActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = pagingAdapter
            addItemDecoration(CatItemDecoration())
        }
    }

    private fun setObservers() {
        viewModel.fetchCats().observe(this, ::bindCats)
        viewModel.openDetailsScreenEvent.observe(this, ::openDetailsScreen)
    }

    private fun bindCats(pagingData: PagingData<CatItem>) {
        pagingAdapter.submitData(lifecycle, pagingData)
    }

    private fun openDetailsScreen(catId: String) {
        val intent = Intent(this, DetailsActivity::class.java)
            .putExtra(DetailsActivity.CAT_ID, catId)
        startActivity(intent)
    }
}