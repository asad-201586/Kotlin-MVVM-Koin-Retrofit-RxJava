package com.mtech.mysecondproject.main.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.main.adapter.MyAdapter
import com.mtech.mysecondproject.main.viewModel.MainViewModel
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

//        mainViewModel.progressObserver.observe(this, {
//            Log.d("test_v", "setUpObserver: value: $it")
//            if (it) loader.visibility = View.VISIBLE
//            else loader.visibility = View.GONE
//        })
    }

    private fun getData() {
        mainViewModel.getPost()
    }

    private fun setUpRecycler() {
        post_rv.setHasFixedSize(true)
        post_rv.layoutManager = LinearLayoutManager(this)
    }
}