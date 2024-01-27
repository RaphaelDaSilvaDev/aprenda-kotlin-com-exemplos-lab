enum class Nivel { BASICO, INTERMEDIARIO,  AVANCADO }

data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    override fun toString(): String {
        val conteudoNomes = conteudos.map{it.nome}
        val inscritosNome = inscritos.map{it.nome}
        return "Curso: $nome, Conteudo: $conteudoNomes, Nivel: $nivel, Inscritos: $inscritosNome"
    }
}

fun main() {
    val lucas = Usuario("Lucas", 18)
    val matheus = Usuario("Matheus", 25)
    
    val kotlinBasico = ConteudoEducacional("Kotlin Basico")
    val kotlinAvancado = ConteudoEducacional("Kotlin Avancado", 120)
    
    val kotlinFormacao = Formacao("Formacao Kotlin", listOf(kotlinBasico, kotlinAvancado), Nivel.INTERMEDIARIO)
    
    kotlinFormacao.matricular(lucas)
    kotlinFormacao.matricular(matheus)
    
    println("${kotlinFormacao}")
}