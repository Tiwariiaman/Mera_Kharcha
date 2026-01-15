package com.amati.merakharcha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.amati.merakharcha.data.ExpenseDatabase
import com.amati.merakharcha.data.ExpenseRepository
import com.amati.merakharcha.dataModel.ExpenseViewModel
import com.amati.merakharcha.dataModel.ExpenseViewModelFactory
import com.amati.merakharcha.ui.theme.MeraKharchaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val database = ExpenseDatabase.getDatabase(this)
        val repository = ExpenseRepository(database.expenseDao())
        val factory = ExpenseViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)
            .get(ExpenseViewModel::class.java)
        setContent {
            MeraKharchaTheme {
                AppNavGraph(viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeraKharchaTheme {

    }
}