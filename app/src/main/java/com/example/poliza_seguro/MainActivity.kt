package com.example.poliza_seguro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.jaredrummler.materialspinner.MaterialSpinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerPolicyType: MaterialSpinner = findViewById(R.id.spinnerPolicyType)
        val checkBoxAlcohol: CheckBox = findViewById(R.id.checkBoxAlcohol)
        val checkBoxGlasses: CheckBox = findViewById(R.id.checkBoxGlasses)
        val checkBoxHealthCondition: CheckBox = findViewById(R.id.checkBoxHealthCondition)
        val checkBoxAgeOver40: CheckBox = findViewById(R.id.checkBoxAgeOver40)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val policyTypes = listOf("(A) Cobertura amplia", "(B) Daños a terceros")

        spinnerPolicyType.setItems(policyTypes)

        calculateButton.setOnClickListener {
            val selectedPolicyType = spinnerPolicyType.selectedIndex
            val baseCost = if (selectedPolicyType == 0) 1200 else 950
            var totalCost = baseCost.toDouble()

            if (checkBoxAlcohol.isChecked) {
                totalCost += baseCost * 0.10 // 10% de recargo
            }

            if (checkBoxGlasses.isChecked) {
                totalCost += baseCost * 0.05 // 5% de recargo
            }

            if (checkBoxHealthCondition.isChecked) {
                totalCost += baseCost * 0.05 // 5% de recargo
            }

            if (checkBoxAgeOver40.isChecked) {
                totalCost += baseCost * 0.20 // 20% de recargo
            } else {
                totalCost += baseCost * 0.10 // 10% de recargo
            }

            resultTextView.text = "Costo de la póliza: $" + String.format("%.2f", totalCost)
        }
    }
}
