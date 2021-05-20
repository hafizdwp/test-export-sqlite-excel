package com.hafizdwp.test_export_sqlite_excel

import android.os.Bundle
import com.hafizdwp.test_export_sqlite_excel.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = obtainViewModel<MainViewModel>()

//        viewModel.start()
//        viewModel.print()

//        val export = SQLiteToExcel(this, "database")
//        export.exportAllTables("tesexport.xls", object : SQLiteToExcel.ExportListener {
//            override fun onStart() {
//                log("exporting...")
//            }
//
//            override fun onCompleted(filePath: String?) {
//                log("export complete!")
//            }
//
//            override fun onError(e: Exception?) {
//                logError("export error: $e")
//            }
//        })

        btn_get.setOnClickListener {
            viewModel.getRandomFact()
        }
        observe(viewModel)
    }

    fun observe(viewModel: MainViewModel) {
        viewModel.apply {
            randomFact.observe {
                text.text = it.toString()
            }
        }
    }
}