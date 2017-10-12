class Avancada(
        private val tipoCorrupcao: Corrupcao,
        private val valorAssociado:Double,
        private val frequencia: Int):Classificacao(){

    fun get_tipoCorrupcao():Corrupcao{
        return this.tipoCorrupcao
    }

    override fun toString(): String {
        return "Avançada - Tipo: ${this.tipoCorrupcao} | Valor: ${this.valorAssociado} | Frequencia: ${this.frequencia}"
    }

}