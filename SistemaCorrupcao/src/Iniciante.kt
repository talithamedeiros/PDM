class Iniciante(
        var descricao:String,
        var usuario:Usuario){
    override fun toString(): String {
        return "${this.descricao}, ${this.usuario}"
    }
}