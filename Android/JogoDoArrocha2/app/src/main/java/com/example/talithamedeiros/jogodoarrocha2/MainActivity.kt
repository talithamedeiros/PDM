package com.example.talithamedeiros.jogodoarrocha2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btnChutar: Button
    lateinit var tvInferior: TextView
    lateinit var tvSuperior: TextView
    lateinit var etChute: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnChutar = findViewById(R.id.btMainChutar)
        this.btnChutar.setOnClickListener({onClick(it)})

        this.tvInferior = findViewById(R.id.tvMainInferior)
        this.tvSuperior = findViewById(R.id.tvMainSuperior)
        this.etChute = findViewById(R.id.etMainChute)

        this.tvInferior.setText("1")
        this.tvSuperior.setText("100")
    }

    fun onClick(view: View){
        val numeroEscolhido = 10
        var pontuacao = 1000
        var chute = this.etChute.text.toString().toInt()
        var inferior = this.tvInferior.text.toString().toInt()
        var superior = this.tvSuperior.text.toString().toInt()

        //perdeu - vai para tela de resultado
        if ((chute == numeroEscolhido) || (chute <= inferior) || (chute >= superior)){
            pontuacao = pontuacao - 10
            val it = Intent(this, ResultadoActivity::class.java)
            it.putExtra("RESULTADO", "Perdeu!")
            it.putExtra("NUMERO", numeroEscolhido.toString())
            it.putExtra("PONTUACAO", pontuacao.toString())
            startActivity(it)
        }
        //altera o limite inferior do intervalo para o número chutado
        else if (chute < numeroEscolhido - 1){
            pontuacao = pontuacao - 10
            this.tvInferior.setText(this.etChute.text.toString())

        }
        //altera o limite superior do intervalo para o número chutado
        else if (chute > numeroEscolhido + 1){
            pontuacao = pontuacao - 10
            this.tvSuperior.setText(this.etChute.text.toString())
        }

        //ganhou - vai para tela de resultado
        else if ((chute == numeroEscolhido + 1) || (chute <= numeroEscolhido - 1)){
            //ganhou
            val it = Intent(this, ResultadoActivity::class.java)
            it.putExtra("RESULTADO", "Ganhou!")
            it.putExtra("NUMERO", numeroEscolhido.toString())
            it.putExtra("PONTUACAO", pontuacao.toString())
            startActivity(it)
        }
    }

}
