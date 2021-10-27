package com.example.expense.data.local.dao

import androidx.room.*
import com.example.expense.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow

// DAO provides common operations with data.

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transaction: Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Query("SELECT * FROM transaction_table ORDER BY date")
    fun getAllTransaction(): Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE id = :id")
    fun getTransactionById(id: Int): Flow<Transaction>
}