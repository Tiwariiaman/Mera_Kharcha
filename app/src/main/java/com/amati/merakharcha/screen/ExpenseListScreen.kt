package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amati.merakharcha.basic.ExpenseTopBar
import com.amati.merakharcha.dataModel.ExpenseViewModel
import org.w3c.dom.Text

@Composable
fun ExpenseListScreen(
    viewModel: ExpenseViewModel,
    onAddClick: () -> Unit,
    onSummaryClick: () -> Unit,
    onChartClick: () -> Unit
) {
    val expenses by viewModel.expenses.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ExpenseTopBar("Mera Karcha")

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = onAddClick) {
                Text("Add Expense")

            }
            Button(onClick = { onSummaryClick() }) {
                Text("View Summary")
            }

            Button(onClick = { onChartClick() }) {
                Text("View Chart")
            }

            //Lazy column for scrollable lists

            Spacer(modifier = Modifier.height(12.dp))
            if (expenses.isEmpty()) {

                Text("No expenses added yet")

            } else {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(expenses) { expense ->
                        Text("₹${expense.amount} - ${expense.category}")
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }


//            expenses.forEach {
//                Text(
//                    "₹${it.amount} - ${it.category} - ${it.note}",
//                    modifier = Modifier.padding(8.dp)
//                )
//            }
        }
    }
}
