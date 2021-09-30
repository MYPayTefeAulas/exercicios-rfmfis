package com.example.myagenda

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myagenda.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)

        binding.btSalvar.setOnClickListener() {
            val nome = binding.txtNome.text.toString()
            val fone = binding.txtFone.text.toString()
            val pessoa = Pessoa(nome, fone)

            if ( pessoa.vericarFoneAgenda()) {
                binding.txtAviso.setTextColor(rgb(216, 10, 12))
                binding.txtAviso.text = "Erro, digitar novmente nome e telefone"
            } else {
                if (!agenda.testarContato(pessoa)) {
                    agenda.salvarContato(pessoa)
                    binding.txtAviso.setTextColor(rgb(216, 12, 12))
                    binding.txtAviso.text = "Contado salvo"
                }
            }
        }
        binding.btProximo.setOnClickListener {
            agenda.salvarContato(novoContato = Pessoa(nome= String(), fone= String()))
            binding.txtAviso.setTextColor(rgb(216, 12, 12))
            binding.txtAviso.text = "Contato Salvo"
        }
        binding.btProximo.setOnClickListener (){
            binding.txtAviso.setText(" ")
            if (agenda.retornarContato() == 0){
                binding.txtAviso.setTextColor(Color.rgb(216, 12, 12))
                binding.txtAviso.text= "nenhum contato salvo para mostrar"
            } else{

            binding.txtNome.setText(agenda.imprimirNomeContato())
            binding.txtFone.setText(agenda.imprimirTelefoneContato())
            }
            binding.btDeletar.setOnClickListener(){
                binding.txtFone.setText(" ")
                binding.txtNome.setText(" ")
                binding.txtAviso.setText(" ")
                if (agenda.removeNumeroContatos()== 0){
                    binding.txtAviso.setTextColor(Color.rgb(216, 12, 12))
                    binding.txtAviso.text = " nunhum contato para mostrar"

                    } else agenda.deletarContato()
                }
            }

        setContentView(binding.root)
    }
}


    class Pessoa(val nome: String, val fone: String) {
        companion object{
            var totalPessoa= 0
            private set
        }
        init {
            totalPessoa++
        }
        fun  verificarNomeAgenda(): Boolean{
            return  nome == " "
        }
        fun  vericarFoneAgenda(): Boolean{
            return  fone== " "
        }

    }