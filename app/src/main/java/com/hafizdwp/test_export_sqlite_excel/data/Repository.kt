package com.hafizdwp.test_export_sqlite_excel.data

import com.hafizdwp.test_export_sqlite_excel.Tes

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class Repository(private val remoteDataSource: RemoteDataSource,
                 private val localDataSource: LocalDataSource) {

    suspend fun initiateTable(list: List<Tes>) {
        localDataSource.initiateTable(list)
    }

    suspend fun getAll(): List<Tes> {
        return localDataSource.getAll()
    }

    companion object {
        private var instance: Repository? = null

        @JvmStatic
        fun getInstance(rds: RemoteDataSource, lds: LocalDataSource): Repository {
            return instance ?: synchronized(Repository::class.java) {
                instance ?: Repository(rds, lds).also {
                    instance = it
                }
            }
        }
    }
}