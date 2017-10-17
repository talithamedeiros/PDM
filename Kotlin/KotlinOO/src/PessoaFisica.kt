class PessoaFisica (
        override var nome:String,
        override var idade:Int,
        var cpf:String): Pessoa (nome, idade) {

    override fun toString(): String {
        return "${super.toString()} - CPF: ${this.cpf}"
    }
}

fun main(args: Array<String>) {
    var pf = PessoaFisica("Primeira pessoa fisica", 1, "1111")

    pf.falar()
    println(pf)
}