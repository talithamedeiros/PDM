class Media(
        private val tipoCorrupcao: Corrupcao,
        private val valorAssociado:Double):Classificacao(){

    fun get_tipoCorrupcao():Corrupcao{
        return this.tipoCorrupcao
    }

    override fun toString(): String {
        return "Média - Tipo: ${this.tipoCorrupcao} | Valor: ${this.valorAssociado}"
    }

}