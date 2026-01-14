package com.amati.merakharcha.dataModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amati.merakharcha.data.ExpenseRepository

class ExpenseViewModelFactory(
    private val repository: ExpenseRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExpenseViewModel(repository) as T
    }
}