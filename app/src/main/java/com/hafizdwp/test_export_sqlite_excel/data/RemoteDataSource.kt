package com.hafizdwp.test_export_sqlite_excel.data

import com.hafizdwp.test_export_sqlite_excel.ktor.END_POINT_RANDOM_FACT
import com.hafizdwp.test_export_sqlite_excel.ktor.RandomFact
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class RemoteDataSource(private val api: HttpClient) {

    suspend fun getRandomFact(): RandomFact {
        return api.get(END_POINT_RANDOM_FACT)
    }
}