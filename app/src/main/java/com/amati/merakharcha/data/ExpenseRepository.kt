package com.amati.merakharcha.data

import kotlinx.coroutines.flow.Flow

class ExpenseRepository (
    private val dao: ExpenseDao){

    suspend fun addExpense (expense: ExpenseEntity){
        dao.insertExpense(expense)
    }

     fun getExpenses(): Flow<List<ExpenseEntity>> {
        return dao.getAllExpenses()
    }

    fun getCategorySummary(): Flow<List<CategoryTotal>> {
        return dao.getCategorySummary()
    }

}