package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amati.merakharcha.basic.ExpenseCard
import com.amati.merakharcha.basic.ExpenseTopBar
import com.amati.merakharcha.dataModel.ExpenseViewModel

@Composable
fun ExpenseListScreen(
    viewModel: ExpenseViewModel,
    onAddClick: () -> Unit,
    onSummaryClick: () -> Unit,
    onChartClick: () -> Unit
) {
    val expenses by viewModel.expenses.collectAsState()

    Scaffold(
        topBar = { ExpenseTopBar("Mera Karcha") },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
////            Button(onClick = onAddClick) {
////                Text("Add Expense")
////
////            }

            if (expenses.isEmpty()) {

                Text("No expenses added yet")

            } else {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onSummaryClick() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("View Summary")
                    }
                    Button(
                        onClick = { onChartClick() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("View Chart")
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(expenses) { expense ->
                        ExpenseCard(expense)
                        Spacer(modifier = Modifier.height(12.dp))

                    }
                }
            }
        }
    }

}
