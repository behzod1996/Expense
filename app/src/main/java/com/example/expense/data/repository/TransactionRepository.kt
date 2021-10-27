package com.example.expense.data.repository

import com.example.expense.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow

// Repository module is for handling operations on data.

interface TransactionRepository {
    suspend fun insert(transaction: Transaction)
    suspend fun update(transaction: Transaction)
    suspend fun delete(transaction: Transaction)
    fun getAllTransaction(): Flow<List<Transaction>>
    fun getById(id: Int): Flow<Transaction>
}