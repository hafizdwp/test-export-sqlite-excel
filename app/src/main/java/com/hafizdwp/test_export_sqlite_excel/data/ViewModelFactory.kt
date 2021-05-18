package com.hafizdwp.test_export_sqlite_excel.data

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hafizdwp.test_export_sqlite_excel.MainViewModel

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(repository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application) =
                instance ?: synchronized(ViewModelFactory::class.java) {
                    instance ?: ViewModelFactory(provideRepository(application.applicationContext))
                            .also { instance = it }
                }

        private fun provideRepository(context: Context): Repository {
            val database = Database.getInstance(context)
            val rds = RemoteDataSource()
            val lds = LocalDataSource.getInstance(database)

            return Repository.getInstance(rds, lds)
        }
    }
}