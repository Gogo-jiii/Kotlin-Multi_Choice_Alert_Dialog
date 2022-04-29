package com.example.multichoicedialog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.multichoicealertdialog.MultiChoiceDialog
import com.example.multichoicealertdialog.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("a", "b", "c")
    var selectedData = booleanArrayOf(false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowMultiChoiceDialog.setOnClickListener(View.OnClickListener {
            val alertDialog = MultiChoiceDialog(this@MainActivity, data, selectedData)
            alertDialog.show(supportFragmentManager, "multi choice dialog")
            alertDialog.isCancelable = false
        })
    }
}