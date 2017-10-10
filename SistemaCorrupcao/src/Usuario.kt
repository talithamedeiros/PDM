class Usuario(
        var nome:String, var salario:Float){
    var tipoCorrupcao = arrayListOf<Corrupcao>()

    override fun toString(): String {
        return "Nome: ${this.nome}, Salario: ${this.salario}, Corrupcao: ${this.tipoCorrupcao}"
    }
}