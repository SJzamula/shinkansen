package com.example.shinkansen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOK: Button = findViewById(R.id.buttonOK)
        buttonOK.setOnClickListener {
            showTrainDetails()
        }
    }

    private fun showTrainDetails() {
        val trainDetails: TextView = findViewById(R.id.trainDetails)

        val fromTextField: EditText = findViewById(R.id.fromTextField)
        val toTextField: EditText = findViewById(R.id.toTextField)
        val fromText = fromTextField.text
        val toText = toTextField.text

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
        val radioButton: TextView = findViewById(intSelectButton)
        //Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
        val time = radioButton.text

        trainDetails.text = "Train from $fromText to $toText at $time"
    }
}
