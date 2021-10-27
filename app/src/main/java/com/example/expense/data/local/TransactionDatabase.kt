package com.example.expense.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expense.data.local.dao.TransactionDao
import com.example.expense.data.local.entity.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase: RoomDatabase() {

    abstract fun getDao() : TransactionDao


}