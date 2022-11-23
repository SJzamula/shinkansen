package com.example.shinkansen

import CustomDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment.*

class FirstFragment : Fragment() {


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment, container, false);
        val buttonOK: Button = view.findViewById(R.id.buttonOK)
        buttonOK.setOnClickListener {
            showTrainDetails(view)
        }
        return view
    }

    fun showTrainDetails(view: View) {
        val trainDetails: TextView = view.findViewById(R.id.trainDetails)

        val fromTextField: EditText = view.findViewById(R.id.fromTextField)
        val toTextField: EditText = view.findViewById(R.id.toTextField)
        val fromText = fromTextField.text
        val toText = toTextField.text
        val radio11: RadioButton = view.findViewById(R.id.radio11)
        val radio15: RadioButton = view.findViewById(R.id.radio15)
        val radio19: RadioButton = view.findViewById(R.id.radio19)
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)

        buttonOK.setOnClickListener{
            if (radio11.isChecked || radio15.isChecked || radio19.isChecked) {
                val intSelectButton: Int = radioGroup.checkedRadioButtonId
                val radioButton: RadioButton = view.findViewById(intSelectButton)
                val time = radioButton.text
                if (fromTextField.text.isEmpty() || toTextField.text.isEmpty() ) {
                    getFragmentManager()?.let { it1 ->
                        CustomDialog.newInstance(
                            "Enter full existing information", "R.string.msg_logout"
                        ).show(it1, CustomDialog.TAG)
                    }
                } else {
                    trainDetails.text = "Train from $fromText to $toText at $time"
                }
            } else {
                getFragmentManager()?.let { it1 ->
                    CustomDialog.newInstance(
                        "Enter full existing information", "R.string.msg_logout"
                    ).show(it1, CustomDialog.TAG)
                }
            }
        }

    }
    internal interface OnFragmentInteractionListener {
        fun onFragmentInteraction(text: String)
    }

}

