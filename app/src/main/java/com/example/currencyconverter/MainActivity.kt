package com.example.currencyconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round


fun convert(amount: Double = 0.00, fromU: String, toU: String): String {
    val currencies: List<String> = listOf(
        "ruble", "euro", "US dollar", "pound sterling", "yen", "yuan", "rupee", "hryvnia")
    val yenEquals: List<Double> = listOf(1.57, 123.48, 108.98, 137.29, 1.0, 15.33, 1.44, 4.08)
    var from: Int = 0
    var to: Int = 0

    for (i in currencies.indices) {
        if (currencies[i] == fromU) {
            from = i
        }
        if (currencies[i] == toU) {
            to = i
        }
    }

    return "%.2f".format(amount * yenEquals[from] / yenEquals[to])
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView3)
        textView.text = "0"
        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            var EditText = findViewById<EditText>(R.id.editValue)
            var result: Double = EditText.text.toString().toDouble()
            var from: String = findViewById<Spinner>(R.id.spinner).selectedItem.toString()
            var to: String = findViewById<Spinner>(R.id.spinner2).selectedItem.toString()
            textView.text = convert(result, from, to)
        }
    }
}