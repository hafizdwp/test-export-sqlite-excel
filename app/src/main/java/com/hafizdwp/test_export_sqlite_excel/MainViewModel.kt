package com.hafizdwp.test_export_sqlite_excel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafizdwp.test_export_sqlite_excel.data.Repository
import com.hafizdwp.test_export_sqlite_excel.ktor.END_POINT_RANDOM_FACT
import com.hafizdwp.test_export_sqlite_excel.ktor.RandomFact
import com.hafizdwp.test_export_sqlite_excel.ktor.ktorHttpClient
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author hafizdwp
 * 18/05/2021
 **/
class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _randomFact = MutableLiveData<String>()
    val randomFact: LiveData<String>
        get() = _randomFact


    fun start() = viewModelScope.launch {
        val initial = arrayListOf(
                Tes(message = "tes 123"),
                Tes(message = "tes 456")
        )

        withContext(Dispatchers.Default) {
            repository.initiateTable(initial)
        }
    }

    fun getRandomFact() = viewModelScope.launch {
        try {
//            log("getting API")
//            val response = withContext(Dispatchers.Default) { repository.getRandomFact() }
//            log(response.toJson())
//            _randomFact.value = response.toJson()

            val client = ktorHttpClient
            val response = withContext(Dispatchers.Default) {
                client.get<RandomFact>(END_POINT_RANDOM_FACT)
            }
            log(response.toJson())
            _randomFact.value = response.toJson()

            client.close()

        } catch (e: Exception) {
            logError(e.message.toString())
        }
    }

    fun print() = viewModelScope.launch {
        val table = repository.getAll()

        log(table.toJson())
    }
}