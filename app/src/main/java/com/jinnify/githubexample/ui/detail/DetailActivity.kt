package com.jinnify.githubexample.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jinnify.githubexample.R
import com.jinnify.githubexample.databinding.ActivityDetailBinding
import com.jinnify.githubexample.utility.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDataBinding()
        eventBinding()
    }

    private fun setupDataBinding() {
        val binding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun eventBinding() {
        val id = intent.getIntExtra("id", 1)
        viewModel.fetchUser(id)

        viewModel.errorLiveData.observe(
            this, Observer {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })
    }
}
