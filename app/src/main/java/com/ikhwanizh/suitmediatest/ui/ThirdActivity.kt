package com.ikhwanizh.suitmediatest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikhwanizh.suitmediatest.R
import com.ikhwanizh.suitmediatest.adapter.MyRecyclerViewAdapter
import com.ikhwanizh.suitmediatest.data.model.Data
import com.ikhwanizh.suitmediatest.databinding.ActivityThirdBinding
import com.ikhwanizh.suitmediatest.viewmodel.ThirdActivityViewModel
import org.koin.android.ext.android.inject

class ThirdActivity : AppCompatActivity(), MyRecyclerViewAdapter.onItemClick {

    private lateinit var binding: ActivityThirdBinding
    private val viewModel: ThirdActivityViewModel by inject()
    private var listUsers: List<Data> = listOf()
    private lateinit var adapterList: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        init()
        observeData()

        setContentView(binding.root)
    }
    private fun init() {
        viewModel.getUsers()
    }

    private fun observeData() {
        with(viewModel) {
            observeUsers.observe(this@ThirdActivity) {
                it.let { data ->
                    binding.apply {
                        listUsers = data.body()?.data ?: listOf()
                        adapterList.differ.submitList(listUsers)
                        with(binding.rvList){
                            adapter = adapterList
                            layoutManager = LinearLayoutManager(context)
                        }
                    }
                }
            }
        }
    }

    override fun setOnItemClick(data: Data, position: Int) {
        startActivity(Intent(this@ThirdActivity, SecondActivity::class.java).apply {
            putExtra("first_name", data.firstName)
            putExtra("last_name", data.lastName)
        })
    }
}