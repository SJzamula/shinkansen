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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOK: Button = findViewById(R.id.buttonOK)
        buttonOK.setOnClickListener {
            showTrainDetails()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showTrainDetails() {
        val trainDetails: TextView = findViewById(R.id.trainDetails)

        val fromTextField: EditText = findViewById(R.id.fromTextField)
        val toTextField: EditText = findViewById(R.id.toTextField)
        val fromText = fromTextField.text
        val toText = toTextField.text
        val radio11: RadioButton = findViewById(R.id.radio11)
        val radio15: RadioButton = findViewById(R.id.radio15)
        val radio19: RadioButton = findViewById(R.id.radio19)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        if (radio11.isChecked || radio15.isChecked || radio19.isChecked) {
            val intSelectButton: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(intSelectButton)
            val time = radioButton.text
            if (fromTextField.text.isEmpty() || toTextField.text.isEmpty() ) {
                CustomDialog(this).customDialog()
            } else {
                trainDetails.text = "Train from $fromText to $toText at $time"
            }
        } else {
            CustomDialog(this).customDialog()
        }
    }

}
