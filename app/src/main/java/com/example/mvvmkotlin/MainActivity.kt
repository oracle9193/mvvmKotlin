package com.example.mvvmkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.example.mvvmkotlin.ui.theme.MvvmKotlinTheme
import com.example.mvvmkotlin.databinding.ActivityMainBinding
import com.example.mvvmkotlin.viewmodel.AccountViewModel

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe changes in the account LiveData
        viewModel.account.observe(this, Observer { account ->
            // Update UI with account data
            binding.savingsBalance.text = "Balance: $${account.savingsBalance}"
            binding.checkingBalance.text = "Balance: $${account.checkingBalance}"
        })
    }
}
