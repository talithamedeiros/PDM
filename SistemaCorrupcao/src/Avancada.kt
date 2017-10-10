class Avancada(
        var tipo:Corrupcao,
        var valor:Float,
        var frequencia:Int,
        var usuario:Usuario){
    override fun toString(): String {
        return "${this.tipo}, ${this.valor}, ${this.frequencia}"
    }
}