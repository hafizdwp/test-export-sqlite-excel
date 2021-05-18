package com.hafizdwp.test_export_sqlite_excel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafizdwp.test_export_sqlite_excel.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author hafizdwp
 * 18/05/2021
 **/
class MainViewModel(private val repository: Repository) : ViewModel() {

    fun start() = viewModelScope.launch {
        val initial = arrayListOf(
                Tes(message = "tes 123"),
                Tes(message = "tes 456")
        )

        withContext(Dispatchers.Default) {
            repository.initiateTable(initial)
        }
    }

    fun print() = viewModelScope.launch {
        val table = repository.getAll()

        log(table.toJson())
    }
}