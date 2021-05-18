package com.hafizdwp.test_export_sqlite_excel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = obtainViewModel<MainViewModel>()

        viewModel.start()
        viewModel.print()
    }
}