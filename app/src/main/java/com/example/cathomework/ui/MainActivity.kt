package com.example.cathomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cathomework.di.App
import com.example.cathomework.R
import com.example.cathomework.di.view_model.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
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