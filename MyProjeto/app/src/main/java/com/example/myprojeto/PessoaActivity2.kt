package com.example.myprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.toColorInt
import com.example.myprojeto.databinding.ActivityFrutas2Binding
import com.example.myprojeto.databinding.ActivityPessoa2Binding

class PessoaActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityPessoa2Binding

    private var nome= " "
    private var idade= 0

    private val listaPessoas= mutableListOf<Pessoa>()
    private var indiceAtual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPessoa2Binding.inflate(layoutInflater)

        binding.btImprimir.setOnClickListener {
            binding.txtSaid.text = imprimePessoa()
        }
        binding.btSalvar.setOnClickListener {
            nome = binding.txtNome.text.toString()
            binding.txtNome.text.clear()
            idade= binding.txtIdade.text.toString().toColorInt()
            binding.txtIdade.text.clear()

            val pessoa = Pessoa(nome, idade)
            listaPessoas.add(pessoa)

        }


        setContentView(binding.root)
    }
    fun imprimePessoa(): String{
        //caso finalize a lista, mostrar "Fim
        //novo botão: do começo
        if (indiceAtual >= listaPessoas.size)
            indiceAtual = 0
        val pessoaAtual = listaPessoas[indiceAtual]
        indiceAtual++
        return "nome: ${pessoaAtual.nome}, idade:${pessoaAtual.idade}"

    }
}
