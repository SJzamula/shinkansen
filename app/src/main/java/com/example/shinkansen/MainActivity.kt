package com.example.shinkansen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }

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

        trainDetails.text = "Train from $fromText to $toText at 15:00"
    }
    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6) + 1
        resultText.text = randomInt.toString()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_3
        }
        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}