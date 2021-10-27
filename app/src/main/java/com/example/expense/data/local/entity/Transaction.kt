package com.example.expense.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_table")
data class Transaction(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String,
    var category: String,
    var amount: String,
    var date: String,
    var tag: String,
)


