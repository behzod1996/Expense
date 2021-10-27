package com.example.expense.data.repository

import com.example.expense.data.local.TransactionDatabase
import com.example.expense.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(private val database: TransactionDatabase) : TransactionRepository {
    override suspend fun insert(transaction: Transaction) = database.getDao().insert(transaction)

    override suspend fun update(transaction: Transaction) = database.getDao().update(transaction)

    override suspend fun delete(transaction: Transaction) = database.getDao().delete(transaction)

    override fun getAllTransaction(): Flow<List<Transaction>> =
        database.getDao().getAllTransaction()

    override fun getById(id: Int): Flow<Transaction> = database.getDao().getTransactionById(id)
}