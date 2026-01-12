package com.amati.merakharcha.dataModel

import androidx.room.Database

@Database
(entities = [ExpenseEntity::class],
    version = 1)
 abstract class ExpenseDatabase {
     abstract fun expenseDao(): ExpenseDao

}