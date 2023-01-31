package com.example.tipcalci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.doOnTextChanged


private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {
    private lateinit var tvBaseAmount: TextView
    private lateinit var tvTip: TextView
    private lateinit var tvTipAmountLabel: TextView
    private lateinit var seekBarTip: SeekBar
    private lateinit var etBaseAmount: EditText
    private lateinit var tvTipAmount: TextView
    private lateinit var buttonView : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvBaseAmount = findViewById(R.id.tvBaseAmount)
        tvTip = findViewById(R.id.tvTip)
        tvTipAmountLabel = findViewById(R.id.tvTipAmountLabel)
        seekBarTip = findViewById(R.id.seekBar)
        etBaseAmount = findViewById(R.id.etBaseAmount)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        buttonView = findViewById(R.id.buttonView)

        etBaseAmount.doOnTextChanged { text, start, before, count ->
            calculateTipAmount()

        }

        seekBarTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvTip.text = "${p1} %"
                calculateTipAmount()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        buttonView.setOnClickListener({
            startActivity(Intent(this , SecondActivity::class.java))
        })



    }

    private fun calculateTipAmount() {

        tvTipAmount.text =
            (etBaseAmount.text.toString().toDouble() * seekBarTip.progress / 100).toString()
    }
}