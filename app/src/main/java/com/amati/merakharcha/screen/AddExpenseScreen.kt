package com.amati.merakharcha.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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


    Column(modifier = Modifier.padding(16.dp)) {

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
            label = { Text("note") }
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