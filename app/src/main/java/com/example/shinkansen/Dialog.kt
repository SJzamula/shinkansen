package com.example.shinkansen

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Button

class CustomDialog(context: Context) : Dialog(context)  {
    fun customDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.popup_window)
        dialog.setTitle("Android Custom Dialog")
        dialog.setCancelable(false)
        val btDialog = dialog.findViewById(R.id.dialogOKBtn) as Button
        btDialog.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        dialog.show()
    }
}