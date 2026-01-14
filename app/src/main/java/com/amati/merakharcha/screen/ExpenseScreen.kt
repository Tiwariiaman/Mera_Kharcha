package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
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
//        expenses.forEach {
//            Text("₹${it.amount} - ${it.category}")
//        }

        AddExpenseScreen(
            onSave = { expense ->
                viewModel.addExpense(expense)
            },
            onBack = TODO()
        )
            expenses.forEach {
            Text("₹${it.amount} - ${it.category}")
        }
    }
}
