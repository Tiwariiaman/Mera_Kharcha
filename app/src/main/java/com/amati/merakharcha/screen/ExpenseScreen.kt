package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.amati.merakharcha.dataModel.ExpenseViewModel

@Composable
fun ExpenseScreen (
    viewModel: ExpenseViewModel
){
    val expenses by viewModel.expenses.collectAsState()

    Column() {

    }
}
