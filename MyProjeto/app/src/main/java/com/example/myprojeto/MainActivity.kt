package com.example.myprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myprojeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        binding.btAdicao.setOnClickListener{
            binding.txtCalculadora.text = adicao()
        }
        binding.btSubtracao.setOnClickListener {
            binding.txtCalculadora.text = subtracao()
        }
        binding.btMultiplicacao.setOnClickListener {
            binding.txtCalculadora.text = multiplicacao()
            }

        binding.btDivisao.setOnClickListener {
            binding.txtCalculadora.text = divisao()
        }
            val view = binding.root

            setContentView(view)
    }
    fun adicao (): String {
        val num1 = binding.txtInput1.text.toString().toDouble()
        val num2 = binding.txtInput2.text.toString().toDouble()
        val resultado= num1 + num2
        return resultado.toString()
    }
    fun subtracao (): String {
        val num1 = binding.txtInput1.text.toString().toDouble()
        val num2 = binding.txtInput2.text.toString().toDouble()
        val resultado = num1 - num2
        return resultado.toString()
    }
    fun multiplicacao (): String {
        val num1 = binding.txtInput1.text.toString().toDouble()
        val num2 = binding.txtInput2.text.toString().toDouble()
        val resultado = num1 * num2
        return resultado.toString()
    }
    fun divisao (): String {
        val num1 = binding.txtInput1.text.toString().toDouble()
        val num2 = binding.txtInput2.text.toString().toDouble()
        val resultado = num1 / num2
        return resultado.toString()
    }

    fun trocaTexto (): String{
        return "oi,\n Sou Raiane"
    }
}