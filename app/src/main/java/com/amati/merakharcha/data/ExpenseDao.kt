package com.amati.merakharcha.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expenses ORDER BY date DESC")
     fun getAllExpenses(): Flow<List<ExpenseEntity>>

    @Query(""" 
        SELECT category, SUM(amount) as total 
        FROM expenses GROUP BY category""")

    fun getCategorySummary(): Flow<List<CategoryTotal>>
}

data class CategoryTotal(
    val category: String,
    val total: Double
)