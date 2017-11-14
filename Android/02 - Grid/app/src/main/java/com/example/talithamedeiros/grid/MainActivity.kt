package com.example.talithamedeiros.grid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridLayout

class MainActivity : AppCompatActivity() {
    lateinit var layout: GridLayout
    var botoes = arrayListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.layout = findViewById(R.id.layoutMain)
        this.criaBotoes()
        this.botoes[0].setOnClickListener({ botao1FoiClicado(it) })
    }

    fun criaBotoes(){
        for (i in 1 .. 40){
            val bt = Button(this)
            bt.setOnClickListener({ clickBotao(it) })
            bt.text = "Botão ${i}"
            this.botoes.add(bt)
            this.layout.addView(bt)
        }
    }

    fun clickBotao(view: View){
        (view as Button).text = "Eita"
    }

    //Click do botão 1
    fun botao1FoiClicado(view: View){
        Log.i("APP", "${(view as Button).text} foi clicado")
        (view as Button).text = "Eita"
    }


}
