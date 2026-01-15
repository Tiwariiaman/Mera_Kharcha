package com.amati.merakharcha

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amati.merakharcha.dataModel.ExpenseViewModel
import com.amati.merakharcha.screen.AddExpenseScreen
import com.amati.merakharcha.screen.CategorySummaryScreen
import com.amati.merakharcha.screen.ExpenseChartScreen
import com.amati.merakharcha.screen.ExpenseListScreen

@Composable
fun AppNavGraph(viewModel: ExpenseViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "list"){

        composable("list"){
            ExpenseListScreen(
                viewModel = viewModel,
                onAddClick = {
                    navController.navigate("add")
                },
                onSummaryClick = {
                    navController.navigate("summary")
                },
                onChartClick = {
                    navController.navigate("charts")
                }
            )
        }
        composable("add"){
            AddExpenseScreen( onSave = {expense -> viewModel.addExpense(expense)},
                onBack = {navController.popBackStack()})
        }

        composable("summary") {
            CategorySummaryScreen(viewModel, onBack = {navController.popBackStack()})
        }

        composable("charts") {
            ExpenseChartScreen(viewModel, onBack = {navController.popBackStack()})
        }
    }
}