class Iniciante(
        private val descricao:String):Classificacao(){
    override fun toString(): String {
        return "Iniciante - Descricao: ${this.descricao}"
    }
}