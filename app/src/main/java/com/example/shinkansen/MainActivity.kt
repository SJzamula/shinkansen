package com.example.shinkansen

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.RadioGroup
import android.widget.TextView

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

    @SuppressLint("SetTextI18n")
    private fun showTrainDetails() {
        val trainDetails: TextView = findViewById(R.id.trainDetails)

        val fromTextField: EditText = findViewById(R.id.fromTextField)
        val toTextField: EditText = findViewById(R.id.toTextField)
        val fromText = fromTextField.text
        val toText = toTextField.text

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val intSelectButton: Int = radioGroup.checkedRadioButtonId
        val radioButton: TextView = findViewById(intSelectButton)
        val time = radioButton.text

        if (fromTextField.text.isEmpty()
            || toTextField.text.isEmpty()
            || intSelectButton == -1
        ) {
            CustomDialog(this).customDialog()
        }  else {
            trainDetails.text = "Train from $fromText to $toText at $time"
        }
    }

}
