package com.example.toast

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment

class TaskEntryDialogeFragment : DialogFragment() {
    var positiveCallback: ((String) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context!!)
        builder.setMessage("Add a new Task?")

        val dialogView = LayoutInflater
            .from(context)
            .inflate(R.layout.dialog_task_entry, null) as LinearLayout
        builder.setView(dialogView)

        builder.setPositiveButton("Okay") { dialog, position ->
            val entry = dialogView.findViewById<EditText>(R.id.editText)
            positiveCallback?.invoke(entry.text.toString())
        }

        builder.setNegativeButton("Cancel") { dialog, position ->

        }

        return builder.create()
    }
}