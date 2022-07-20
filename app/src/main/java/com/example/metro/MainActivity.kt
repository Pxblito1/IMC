package com.example.metro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckedTextView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.metro.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var height = 150
    var weight = 75
    var doubleHeight = 2.25
    var IMC = 33.33
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sBaltura.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                binding.tvalturaa.text = seek.progress.toString().plus("/200")
                height = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                calcIMC()
            }
        })
        binding.sBpeso.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                binding.tvpesoo.text = seek.progress.toString().plus("/150")
                weight = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                calcIMC()
            }
        })
        binding.imageView.setOnClickListener {
            val inflater = this!!.layoutInflater
            val custom_layout = inflater.inflate(R.layout.tostada, null)
            AlertDialog.Builder(this!!)
                .setView(custom_layout)
                .setPositiveButton("aceptar",null)
                .setNegativeButton("", null)
                .show()
        }
    }

    fun calcIMC() {
        doubleHeight = height.times(height) / 10000.0
        IMC = Math.round(
            (weight / doubleHeight)
                .times(100)
        )
            .div(100.0)

        binding.tvIMc.text = IMC.toString()
        calcObesidad()
    }

    fun calcObesidad() {
    val msj = when(IMC){
        in 0.0..16.00 ->Snackbar.make(binding.root,"Delgadez Severa",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){ val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.purple_700)).show()
        in 16.01 .. 16.99 -> Snackbar.make(binding.root,"Delgadez Moderada",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Azul)).show()
        in 17.00 .. 18.49 -> Snackbar.make(binding.root,"Delgadez Leve",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Azulflojo)).show()
        in 18.50..24.99 -> Snackbar.make(binding.root,"Peso normal",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Verde)).show()
        in 25.00 .. 29.99-> Snackbar.make(binding.root,"PreObesidad",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Verdeflojo)).show()
        in 30.00 .. 34.99 -> Snackbar.make(binding.root,"Obesidad Leve",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Amararillo)).show()
        in 35.00 .. 39.99 ->Snackbar.make(binding.root,"Obesidad Media",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()}.setBackgroundTint(getColor(R.color.Naranja)).show()
        in 40.00 .. 40000.00 -> Snackbar.make(binding.root,"Obesidad Morbida",Snackbar.LENGTH_SHORT).setAction("Ver Tabla"){
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tostada,null)
            AlertDialog.Builder(this!!).setView(customlayout).show()
        }.setBackgroundTint(getColor(R.color.Rojo)).show()
        else -> return
        }
    }
}