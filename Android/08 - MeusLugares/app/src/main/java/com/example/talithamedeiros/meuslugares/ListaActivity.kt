package com.example.talithamedeiros.meuslugares

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ListaActivity : AppCompatActivity() {
    lateinit var listalugares : ListView
    lateinit var btVoltar : Button
    var meuslugares = arrayListOf<Lugar>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        this.btVoltar = findViewById(R.id.btListaVoltar)
        this.btVoltar.setOnClickListener({voltar(it)})

        this.listalugares = findViewById(R.id.lvLugares)

        meuslugares = intent.getParcelableArrayListExtra<Lugar>("REGISTRO")

        val adapter = ArrayAdapter<Lugar>(this, android.R.layout.simple_list_item_1, meuslugares)
        this.listalugares.adapter = adapter

        this.listalugares.setOnItemClickListener({parent, view, position, id ->
            val it = Intent(this, RegistroActivity::class.java)
            it.putExtra("ITEM", this.meuslugares[position])
            startActivity(it)
        })
    }
    fun voltar(view: View){
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }
}
