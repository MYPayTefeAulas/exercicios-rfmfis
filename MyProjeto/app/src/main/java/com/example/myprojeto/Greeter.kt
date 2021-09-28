package com.example.myprojeto

class GreeterTipo1 (val cumprimento: String){

    fun greete (nome: String):String{
        val cumprimentoCompleto= "$cumprimento $nome"
        return cumprimentoCompleto
    }

}
