fun main(args: Array<String>) {
    /*Tipos de Corrupcao:
    Ativa(praticada contra funcionário público);
    Passiva(praticada pelo funcionário público);
    Sistêmica(generalizada).

    *Classificação das corrupções:
    Iniciante(descrição da ação)
    Média(Tipo<corrupção> e o valor associado)
    Avançada(Tipo<corrupção>, valor associado e frequência)
     */

    val inicianteTam = arrayListOf<Iniciante>()
    val mediaTam = arrayListOf<Media>()
    val avancTam = arrayListOf<Avancada>()
    val ativa = Corrupcao("Ativa")
    val passiva = Corrupcao("Passiva")
    val sistemica = Corrupcao("Sistemica")
    val usuarios = arrayListOf<Usuario>()
    var contAtiva = 0
    var contPassiva = 0
    var contSistemica = 0

    //Usuario 1
    //corrupcao iniciante
    val joao = Usuario("Joao", 10000f) // Registra nome e renda
    inicianteTam.add(Iniciante("Recebi dinheiro a mais no troco", joao)) //add usuario na lista de corrupcoes iniciantes


    //Usuario 2
    val michel = Usuario("Michel", 1000000f)
    //corrupcao ativa
    michel.tipoCorrupcao.add(ativa)
    //classificacao media
    mediaTam.add(Media(michel.tipoCorrupcao.get(0), 100000f, michel))

    //corrupcao passiva
    michel.tipoCorrupcao.add(passiva)
    // classificacao avancada
    avancTam.add(Avancada(michel.tipoCorrupcao.get(1), 100000f, 30, michel))

    //corrupcao sistemica
    michel.tipoCorrupcao.add(sistemica)
    //classificacao avancada
    avancTam.add(Avancada(michel.tipoCorrupcao.get(2), 90000f, 30, michel))


    //Usuario 3
    val jair = Usuario("Jair", 10000f)
    //corrupcao sistemica
    jair.tipoCorrupcao.add(sistemica)
    //classificacao media
    mediaTam.add(Media(jair.tipoCorrupcao.get(0), 100000f, jair))

    usuarios.add(michel)
    usuarios.add(jair)
    usuarios.add(joao)

    //por classificacao
    println("- Quantidades por classificação -\nIniciante: ${inicianteTam.size}\nAvançada: ${avancTam.size}\nMédia: ${mediaTam.size}")

    for (i in usuarios){
        if (i.tipoCorrupcao.contains(ativa)){
            contAtiva++
        }
        if (i.tipoCorrupcao.contains(passiva)){
            contPassiva++
        }
        if (i.tipoCorrupcao.contains(sistemica)){
            contSistemica++
        }
    }

    //por tipo
    println("\n- Quantidades por tipo -\nAtiva: ${contAtiva}\nPassiva: ${contPassiva}\nSistemica: ${contSistemica}")

    println("\n-----Tabela de Tipos de corruptos-----")
    println("\n- Iniciante -")
    //classificacao iniciante
    for (i in inicianteTam){
        println("${i.usuario.nome} - ${i.descricao} ")
    }

    println("\n- Ladrão -")
    //Corrupcao ativa e media
    for (m in mediaTam){
        if (m.usuario.tipoCorrupcao.contains(ativa)){
            println("${m.usuario.nome} - ${m.valor}")
        }
    }

    println("\n- Criminoso -")
    //Corrupcao sistemica, avancada e media
    val usu = hashSetOf<String>()
    for(a in avancTam){
        for (m in mediaTam){
            if(a.usuario.tipoCorrupcao.contains(sistemica) && (m.usuario.tipoCorrupcao.contains(sistemica))){
                usu.add(a.usuario.nome)
                usu.add(m.usuario.nome)
            }
        }
    }
    println(usu)

}