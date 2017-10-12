fun main(args: Array<String>) {
    val usuarios = arrayListOf<Usuario>()
    var contIni=0
    var contMedia=0
    var contAvancada=0
    var contAtiva=0
    var contSistemica=0
    var contPassiva=0

    val vold = Usuario("Voldemort", 1000.0)
    vold.addIniciante("Recebeu dinheiro a mais no troco e não devolveu")
    vold.addMedia(Corrupcao.ATIVA,1000.0)

    val bolso = Usuario("Bolsominion", 100000000.0)
    bolso.addAvancada(Corrupcao.SISTEMICA, 100000.1, 5)
    bolso.addMedia(Corrupcao.PASSIVA, 8000.3)

    val michel = Usuario("Michelzinho", 20000.0)
    michel.addAvancada(Corrupcao.SISTEMICA, 1000000.0, 8)
    michel.addMedia(Corrupcao.ATIVA, 8000.3)

    usuarios.add(vold)
    usuarios.add(bolso)
    usuarios.add(michel)

    //qtde por classificações
    for(u in usuarios){
        for (corrupcao in u.corrupcoes){
            if(corrupcao is Iniciante){
                contIni++
            }
            else if(corrupcao is Media){
                contMedia++
            }
            else contAvancada++
        }
    }
    println("- Quantidades por classificação -\nIniciante: ${contIni}\nMédia: ${contMedia}\nAvançada: ${contAvancada}")

    //qtde por tipo
    for(u in usuarios){
        for (corrupcao in u.get_corrupcoes()){ //verifica a lista de corrupcoes
            if (corrupcao is Media){ //verifica corrupcao média pois contem tipo
                if (corrupcao.get_tipoCorrupcao().equals(Corrupcao.ATIVA)) contAtiva++
                else if(corrupcao.get_tipoCorrupcao().equals(Corrupcao.PASSIVA)) contPassiva++
                else contSistemica++
            }
            if(corrupcao is Avancada){ //verifica corrupcao avancada pois contem tipo
                if (corrupcao.get_tipoCorrupcao().equals(Corrupcao.ATIVA)) contAtiva++
                else if(corrupcao.get_tipoCorrupcao().equals(Corrupcao.PASSIVA)) contPassiva++
                else contSistemica++
            }
        }
    }
    println("\n- Quantidades por tipo -\nAtiva: ${contAtiva}\nPassiva: ${contPassiva}\nSistemica: ${contSistemica}")

    println("\n-----Tabela de Tipos de corruptos-----")
    println("- Iniciante -")
    for(u in usuarios){
        for (corrupcao in u.get_corrupcoes()){
            if (corrupcao is Iniciante){
                println(u.getNome())
            }
        }
    }

    println("- Corrupto de respeito -")
    for(u in usuarios){
        for (corrupcao in u.get_corrupcoes()){
            if (corrupcao is Media){
                if (corrupcao.get_tipoCorrupcao().equals(Corrupcao.PASSIVA))
                    println(u.getNome())
            }
        }
    }

    println("- Ninja da corrupcao -")
    for(u in usuarios){
        for (corrupcao in u.get_corrupcoes()){
            if (corrupcao is Avancada){
                if (corrupcao.get_tipoCorrupcao().equals(Corrupcao.SISTEMICA))
                    println(u.getNome())
            }
        }
    }
}