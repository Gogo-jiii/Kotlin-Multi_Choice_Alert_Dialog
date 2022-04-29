package com.example.multichoicealertdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.content.DialogInterface.OnMultiChoiceClickListener
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MultiChoiceDialog(
    private val _context: Context,
    private val data: Array<String>,
    private val selectedData: BooleanArray
) : DialogFragment() {
    private var builder: AlertDialog.Builder? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        builder = AlertDialog.Builder(_context)
        builder!!.setTitle("Multi Choice Alert Dialog")
        builder!!.setMultiChoiceItems(data, selectedData) { dialogInterface, i, b ->
            val currentItem = data[i]
            Toast.makeText(context, "Current Item: $currentItem", Toast.LENGTH_SHORT).show()
        }
        builder!!.setPositiveButton("OK") { dialogInterface, j ->
            dialogInterface.dismiss()
            for (i in data.indices) {
                if (selectedData[i] == true) {
                    Toast.makeText(context, "Selected: " + data[i], Toast.LENGTH_SHORT).show()
                    selectedData[i] = false
                }
            }
        }
        builder!!.setNegativeButton("CANCEL") { dialogInterface, i ->
            dialogInterface.dismiss()
            Toast.makeText(context, "Cancelled.", Toast.LENGTH_LONG).show()
        }
        return builder!!.create()
    }
}