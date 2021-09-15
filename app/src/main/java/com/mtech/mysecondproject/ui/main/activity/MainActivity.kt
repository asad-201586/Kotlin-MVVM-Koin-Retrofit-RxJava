package com.mtech.mysecondproject.ui.main.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.ui.main.adapter.MyAdapter
import com.mtech.mysecondproject.ui.main.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecycler()
        getData()
        setUpObserver()

    }

    private fun setUpObserver() {
        mainViewModel.myObserver.observe(this, {
            val adapter = MyAdapter(this,it)
            post_rv.adapter = adapter
        })

        mainViewModel.loaderObserver.observe(this, {
            if (it) loader.visibility = View.VISIBLE
            else loader.visibility = View.GONE
        })
    }

    private fun getData() {
        mainViewModel.getPost()
    }

    private fun setUpRecycler() {
        post_rv.setHasFixedSize(true)
        post_rv.layoutManager = LinearLayoutManager(this)
    }
}