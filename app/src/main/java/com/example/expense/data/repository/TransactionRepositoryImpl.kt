package com.example.expense.data.repository

import com.example.expense.data.local.TransactionDatabase
import com.example.expense.data.local.dao.TransactionDao
import com.example.expense.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(private val dao: TransactionDao) : TransactionRepository {
    override suspend fun insert(transaction: Transaction) = dao.insert(transaction)

    override suspend fun update(transaction: Transaction) = dao.update(transaction)

    override suspend fun delete(transaction: Transaction) = dao.delete(transaction)

    override fun getAllTransaction(): Flow<List<Transaction>> = dao.getAllTransaction()

    override fun getById(id: Int): Flow<Transaction> = dao.getTransactionById(id)
}

