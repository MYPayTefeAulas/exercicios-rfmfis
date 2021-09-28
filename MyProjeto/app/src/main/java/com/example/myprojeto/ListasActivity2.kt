package com.example.myprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojeto.databinding.ActivityFrutas2Binding as ActivityFrutas2Binding1

class ListasActivity2 : AppCompatActivity() {

    private lateinit var binding: com.example.myprojeto.databinding.ActivityFrutas2Binding

    private val listaFrutas = listOf("maca", "mamao", "abacate")
    private val listaVegetais = listOf("pepino", "pimentao", "alface")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrutas2Binding1.inflate(layoutInflater)

        binding.btAnalisar.setOnClickListener {
            binding.txtSaida.text = analisar(binding.txtEntrada.text.toString())
        }
        setContentView(binding.root)
    }

    fun analisar(entrada: String): String {
        var saida = " "

        var encontrouAlimento = false

        for (fruta in listaFrutas) {
            if (fruta == entrada) {
                saida = "É fruta"
                encontrouAlimento = true
                break
            }
        }
        for(vegetal in listaVegetais) {
            if (vegetal == entrada) {
                saida = "É Vevetal"
                encontrouAlimento = true
                break
            }

        }

        if (encontrouAlimento){
            saida == "Não sei o que é isso"
        }
        return saida
    }
}