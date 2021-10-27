package com.example.expense.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expense.data.local.dao.TransactionDao
import com.example.expense.data.local.entity.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun getDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: TransactionDatabase? = null

        fun getTransactionDatabase(context: Context): TransactionDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TransactionDatabase::class.java,
                    "transaction_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}