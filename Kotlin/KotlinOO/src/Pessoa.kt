open class Pessoa(
        open var nome:String,
        open protected var idade:Int): Comunicar{

    override fun toString(): String{
        return "Nome: ${this.nome} - Idade: ${this.idade}"
    }

    override fun falar(){
        println("${this.nome} bla")
    }

    override fun escutar(frase:String){
        println(frase)
    }

    fun add(idade:Int = 0){
        if (idade < 0) throw Throwable()
        this.idade += if (idade == 0) 1 else idade
    }
}


fun main(args: Array<String>) {
    var p = Pessoa("Primeira", 1)

    println(p)
}