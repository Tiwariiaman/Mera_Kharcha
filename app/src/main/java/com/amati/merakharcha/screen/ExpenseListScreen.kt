package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.amati.merakharcha.dataModel.ExpenseViewModel
import org.w3c.dom.Text

@Composable
fun ExpenseListScreen(
    viewModel: ExpenseViewModel,
    onAddClick: () -> Unit,
) {
    val expenses by viewModel.expenses.collectAsState()

    Column() {
        Button(onClick = onAddClick) {
            Text("Add Expense")

        }
        expenses.forEach {
            Text("₹${it.amount} - ${it.category}")
        }
    }

}