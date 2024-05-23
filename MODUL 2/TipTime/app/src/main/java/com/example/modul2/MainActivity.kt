package com.example.modul2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextBiayaLayanan: EditText
    private lateinit var radioGroupTip: RadioGroup
    private lateinit var saklarPembulatan: Switch
    private lateinit var tombolHitung: Button
    private lateinit var textViewTotalTip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextBiayaLayanan = findViewById(R.id.biaya_layanan)
        radioGroupTip = findViewById(R.id.tip)
        saklarPembulatan = findViewById(R.id.pembulatan)
        tombolHitung = findViewById(R.id.tombol_hitung)
        textViewTotalTip = findViewById(R.id.hasil_tip)

        textViewTotalTip.text = getString(R.string.jumlah_tip_default)

        tombolHitung.setOnClickListener {
            tipCalculate()
        }
    }

    private fun tipCalculate() {
        val biayaLayanan = editTextBiayaLayanan.text.toString().toDoubleOrNull()
        if (biayaLayanan == null || biayaLayanan <= 0) {
            textViewTotalTip.text = getString(R.string.invalid_input)
            return
        }

        val persentaseTipTerpilih = when (radioGroupTip.checkedRadioButtonId) {
            R.id.dua_puluh_persen -> 0.20
            R.id.delapan_belas_persen -> 0.18
            R.id.lima_belas_persen -> 0.15
            else -> 0.15
        }

        var jumlahTip = biayaLayanan * persentaseTipTerpilih
        if (saklarPembulatan.isChecked) {
            jumlahTip = kotlin.math.ceil(jumlahTip)
        }

        val tipFormat = String.format("%.2f", jumlahTip)
        textViewTotalTip.text = getString(R.string.jumlah_tip, tipFormat)
    }
}