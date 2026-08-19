package com.example.a3_1mod2handson1

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.a3_1mod2handson1.databinding.ActivityMainBinding
import com.example.a3_1mod2handson1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        binding.btnAskAI.setOnClickListener {
            val prompt = binding.etPrompt.text.toString().trim()
            if (prompt.isNotEmpty()) {
                viewModel.askAI(prompt)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.response.observe(this) { response ->
            binding.tvResponse.text = response
        }

        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnAskAI.isEnabled = !isLoading
        }
    }
}
