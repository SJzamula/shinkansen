package com.example.shinkansen

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView

class MainActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPrefs()

        val buttonOK: Button = findViewById(R.id.buttonOK)
        buttonOK.setOnClickListener {
            showTrainDetails()
        }
    }

    private fun initPrefs(){
        preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    private fun showTrainDetails() {
        val trainDetails: TextView = findViewById(R.id.trainDetails)

        val fromTextField: EditText = findViewById(R.id.fromTextField)
        val toTextField: EditText = findViewById(R.id.toTextField)
        val fromText = fromTextField.text
        val toText = toTextField.text

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val intSelectButton: Int = radioGroup.checkedRadioButtonId
        val radioButton: TextView = findViewById(intSelectButton)
        //Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
        val time = radioButton.text
        if (fromTextField.text.length == 0
            || toTextField.text.length == 0
            || intSelectButton == -1) {
        showDialog()
        }  else {
            trainDetails.text = "Train from $fromText to $toText at ${radioButton.text}"
        }
    }

    fun showDialog(){
        val dialog = MaterialDialog(this)
            .noAutoDismiss()
            .customView(R.layout.popup_window)

        dialog.show()

    }
}
