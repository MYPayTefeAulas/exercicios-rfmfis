package com.example.myprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojeto.databinding.ActivityGreeter2Binding

class GreeterActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter2Binding
    private val listaDeNomes = mutableListOf<String>()
    private var indiceActual = 0
    private var greeterAtual= 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreeter2Binding.inflate(layoutInflater)

        //codigo de confihuraçao de variaves
        val greeter1 = GreeterTipo1("Olá")
        val greeter2 = GreeterTipo1("Bem vindo")
        listaDeNomes.add("Raiane")
        listaDeNomes.add("Maria")
        listaDeNomes.add("Willian")

        // configurações de botões
        binding.btImprimirProximo.setOnClickListener {
            val nomeAtual = listaDeNomes[indiceActual]

            when (greeterAtual) {
                1 -> binding.txtSaidaGreeter.text = greeter1.greete(nomeAtual)
                2 -> binding.txtSaidaGreeter.text = greeter2.greete(nomeAtual)
            }

            if (indiceActual == listaDeNomes.size - 1) {
                indiceActual = 0
            } else {
                indiceActual++
            }
        }

        binding.btTrocaGreeter.setOnClickListener {
            if (greeterAtual == 1) {
                greeterAtual = 2
                binding.txtNumeroGreeter.text = "2"
            } else{
                greeterAtual = 1
                binding.txtNumeroGreeter.text = "1"
            }
        }

        setContentView(binding.root)
    }
}