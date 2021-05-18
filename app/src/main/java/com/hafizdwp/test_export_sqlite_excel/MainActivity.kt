package com.hafizdwp.test_export_sqlite_excel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajts.androidmads.library.SQLiteToExcel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = obtainViewModel<MainViewModel>()

        viewModel.start()
        viewModel.print()

        val export = SQLiteToExcel(this, "database")
        export.exportAllTables("tesexport.xls", object : SQLiteToExcel.ExportListener {
            override fun onStart() {
                log("exporting...")
            }

            override fun onCompleted(filePath: String?) {
                log("export complete!")
            }

            override fun onError(e: Exception?) {
                logError("export error: $e")
            }
        })
    }
}