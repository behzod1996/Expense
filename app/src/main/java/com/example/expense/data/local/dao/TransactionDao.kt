package com.example.expense.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.expense.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transaction: Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    fun getAllTransaction(): Flow<List<Transaction>>
    fun getTransactionById(id: Int): Flow<Transaction>
}