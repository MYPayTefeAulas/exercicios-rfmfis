package com.example.myagenda

class Agenda() {

    private val listaContato= mutableListOf<Pessoa>()
    private var indiceAtual= 0

    fun testarContato(contato: Pessoa): Boolean {
        var encontrou = false
        for (contatoLista in listaContato) {
            if ( (contatoLista.fone == contato.fone)) {
                encontrou = true
                break
            }
        }
        return encontrou
    }
    fun salvarContato(novoContato: Pessoa){
        listaContato.add(novoContato)
    }
    fun imprimirNomeContato():String{
        if (indiceAtual== listaContato.size)
            indiceAtual= 0
        val contatoAtual = listaContato[indiceAtual]
        indiceAtual++
        return "${contatoAtual.nome}"

    }
    fun imprimirTelefoneContato():String{
        indiceAtual -= 1
        if(indiceAtual == listaContato.size)
            indiceAtual = 0
        val contatoAtual = listaContato[indiceAtual]
        indiceAtual++
        return  "${contatoAtual.fone}"
    }
    fun retornarContato(): Int {
        return listaContato.size
    }
    fun deletarContato(){
        if (indiceAtual>= 1){
            indiceAtual-= 1
            val contatoAtual = listaContato[indiceAtual]
            listaContato.remove(contatoAtual)
        } else{
            val contatoAtual = listaContato[indiceAtual]
            listaContato.remove(contatoAtual)
        }
    }
    fun removeNumeroContatos():Int{
        return listaContato.size
    }


}