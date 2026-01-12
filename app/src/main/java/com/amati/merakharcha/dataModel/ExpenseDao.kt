package com.amati.merakharcha.dataModel

import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface ExpenseDao {

    @Insert
    suspend fun insertExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): Flow<List<ExpenseEntity>>

}