enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if(!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na formacao $nome")
        } else {
            println("${usuario.nome} ja esta matriculado na formacao $nome")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Estruturas de decisao", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Orientacao a objetos", Nivel.INTERMEDIARIO, 120)
    
    val formacao = Formacao("Kotlin", listOf(conteudo1, conteudo2))
    
    val usuario1 = Usuario("Anderson")
    val usuario2 = Usuario("Jose")
    formacao.matricular(usuario1)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    println("Formacao: ${formacao.nome}")
    println("Conteudos:")
    formacao.conteudos.forEach {
        c -> println(c.nome)
    }
    println("Inscritos:")
    formacao.inscritos.forEach {
        i -> println(i.nome)
    }
}