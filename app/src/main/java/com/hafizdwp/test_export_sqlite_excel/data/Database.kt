package com.hafizdwp.test_export_sqlite_excel.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hafizdwp.test_export_sqlite_excel.Tes
import com.hafizdwp.test_export_sqlite_excel.TesDao

@androidx.room.Database(entities = [Tes::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun tesDao(): TesDao

    companion object {
        @Volatile
        private var instance: Database? = null

        fun getInstance(context: Context): Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "database"
                )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this codelab.
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                this.instance = instance

                // return instance
                instance
            }
        }
    }
}