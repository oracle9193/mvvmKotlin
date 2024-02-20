package com.example.mvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlin.model.Account

class AccountViewModel : ViewModel() {
    val account = MutableLiveData<Account>()

    init {
        // Initialize account
        account.value = Account("Chithira", 1000.0, 500.0)
    }
}
