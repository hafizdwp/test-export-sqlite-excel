package com.hafizdwp.test_export_sqlite_excel

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author hafizdwp
 * 18/05/2021
 **/

@Entity(tableName = "test")
data class Tes(

        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        var message: String
)