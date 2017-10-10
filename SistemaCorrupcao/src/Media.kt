class Media(
        var tipo:Corrupcao,
        var valor:Float,
        var usuario:Usuario){
    override fun toString(): String {
        return "${this.tipo}, ${this.valor}"
    }
}