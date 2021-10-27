package com.example.expense.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expense.data.local.dao.TransactionDao
import com.example.expense.data.local.entity.Transaction

// Database class holds the database and is the main access point for underlying connection to our app.
// Abstract class gives us complete control over our model and DAO classes.
// The class is defined an abstract, because, Room creates implementation for us.

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase : RoomDatabase() {

    // Connects the database to TransactionDao.
    // Returns an instance of TransactionDao.
    abstract fun getDao(): TransactionDao

    // companion object:
    // Use a companion object to get static access to the database instance.
    companion object {
        // @Volatile:
        // It means that changes made by one thread to shared data are visible to other threads
        @Volatile
        private var INSTANCE: TransactionDatabase? = null

        // getTransactionDatabase():
        // The purpose of function is get instance of database.
        // This function is threadsafe and implementation of a Singleton-Pattern.
        fun getTransactionDatabase(context: Context): TransactionDatabase {

            // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
            // Smart cast is only available to local variables.
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a time.
            synchronized(this) {
                // Inside the synchronized block, create a val instance variable,
                // and use the database builder to get the database.

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TransactionDatabase::class.java,
                    "transaction_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                // Return an instance, the smart cast to be non-null.
                return instance
            }
        }
    }
}


