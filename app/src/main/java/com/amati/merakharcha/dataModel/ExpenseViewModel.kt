package com.amati.merakharcha.dataModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ExpenseViewModel: ViewModel() {
     private val _expenses = MutableStateFlow<List<ExpenseEntity>>(emptyList())
    val expenses = _expenses

    fun addExpense(expense: ExpenseEntity) {
        _expenses.value += expense
    }

}