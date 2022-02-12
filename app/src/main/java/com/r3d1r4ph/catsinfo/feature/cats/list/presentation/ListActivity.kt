package com.r3d1r4ph.catsinfo.feature.cats.list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.r3d1r4ph.catsinfo.R
import com.r3d1r4ph.catsinfo.databinding.ActivityListBinding
import com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler.CatItemDecoration
import com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler.CatPagingAdapter

class ListActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(ActivityListBinding::bind, R.id.rootLayout)
    private val pagingAdapter = CatPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        configureRecycler()
    }

    private fun configureRecycler() {
        viewBinding.listRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@ListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = pagingAdapter
            addItemDecoration(CatItemDecoration())
        }
    }
}