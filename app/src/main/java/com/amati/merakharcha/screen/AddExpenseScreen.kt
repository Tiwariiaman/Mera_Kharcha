package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amati.merakharcha.data.ExpenseEntity

@Composable
fun AddExpenseScreen(
    onSave: (ExpenseEntity) -> Unit,
    onBack: () -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Expense form
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Add Expense", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            error?.let {
                Text(text = it, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = note,
                onValueChange = { note = it },
                label = { Text("UPI/Cash") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                val amountValue = amount.toDoubleOrNull()

                when {
                    amountValue == null || amountValue <= 0 -> {
                        error = "Invalid amount"
                    }

                    category.isBlank() -> {
                        error = "Invalid category"
                    }

                    note.isBlank() -> {
                        error = "Invalid note"
                    }


                    else -> {
                        onSave(
                            ExpenseEntity(
                                amount = amount.toDouble(),
                                category = category,
                                note = note,
                                date = System.currentTimeMillis()
                            )
                        )
                        onBack()
                    }
                }
            }) {
                Text("Save")
            }

        }
    }
}