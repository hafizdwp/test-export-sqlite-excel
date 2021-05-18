package com.hafizdwp.test_export_sqlite_excel

import androidx.room.Dao
import androidx.room.Query
import com.hafizdwp.test_export_sqlite_excel.base.BaseDao

/**
 * @author hafizdwp
 * 18/05/2021
 **/

@Dao
abstract class TesDao : BaseDao<Tes> {

    @Query("SELECT * FROM test")
    abstract suspend fun getAll(): List<Tes>
}