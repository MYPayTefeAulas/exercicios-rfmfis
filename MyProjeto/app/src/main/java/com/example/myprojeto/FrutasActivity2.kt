package com.example.myprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojeto.databinding.ActivityFrutas2Binding
import com.example.myprojeto.databinding.ActivityFrutas2Binding as ActivityFrutasBinding1

class FrutasActivity2 : AppCompatActivity() {

    private  lateinit var binding: ActivityFrutas2Binding

    private val ListaFrutas = listOf("maca", "mamão","abacate")
    private val ListaVegetais = listOf("peppino", "alface", "pimentão")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrutas2Binding.inflate(layoutInflater)

        binding.btAnalisar.setOnClickListener {
            binding.txtSaida.text = analisar(binding.txtEntrada.text.toString())
        }
        setContentView(binding.root)
    }
    fun analisar (entrada: String): String {
        var saida = " "
        var encontrouAlimento = false
        for (fruta in ListaFrutas){
            if(fruta == entrada) {
                saida = "fruta"
                encontrouAlimento = true
            }
            break
        }
        for (vegetal in ListaVegetais) {}

        return saida
    }
}