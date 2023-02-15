package com.example.cathomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cathomework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val button = findViewById<Button>(R.id.btn)

        viewModel.apply {
            getBreeds()
            viewModel.breedLiveData.observe(this@MainActivity) {
                val breedsNameList: List<String> =
                    viewModel.breedLiveData.value?.map { it.breed } ?: listOf()
                spinner.adapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    breedsNameList
                )
            }
        }
        button.setOnClickListener {
            viewModel.apply {
                getCatImage(spinner.selectedItem.toString())
                catLiveData.observe(this@MainActivity) {
                    val adapter = CatAdapter(it)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                }
            }
        }
    }
}