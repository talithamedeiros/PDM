class Usuario(
        private val nome: String,
        private val rendaMensal: Double){
    val corrupcoes = arrayListOf<Classificacao>()

    override fun toString(): String {
        return "Nome: ${this.nome}, Salario: ${this.rendaMensal}, Corrupcao: ${this.corrupcoes}"
    }

    fun addIniciante(d:String){
        this.corrupcoes.add(Iniciante(d))
    }

    fun addMedia(c:Corrupcao,v:Double){
        this.corrupcoes.add(Media(c,v))
    }

    fun addAvancada(c:Corrupcao,v:Double,f:Int){
        this.corrupcoes.add(Avancada(c,v,f))
    }

    fun get_corrupcoes():ArrayList<Classificacao>{
        return this.corrupcoes
    }

    fun getNome():String{
        return this.nome
    }


}