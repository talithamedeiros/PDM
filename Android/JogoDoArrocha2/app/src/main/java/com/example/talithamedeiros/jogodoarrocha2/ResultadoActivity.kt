package com.example.talithamedeiros.jogodoarrocha2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ResultadoActivity : AppCompatActivity() {

    lateinit var tvSituacao : TextView
    lateinit var tvNumero : TextView
    lateinit var tvPt : TextView
    lateinit var layout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.layout = findViewById(R.id.layoutResultado)
        this.tvSituacao = findViewById(R.id.tvResultadoSituacao)
        this.tvNumero = findViewById(R.id.tvResultadoNumero)
        this.tvPt = findViewById(R.id.tvResultadoPontuacao)

       //intent = getIntent()

        var resultado = intent?.getStringExtra("RESULTADO")
        var numero = intent?.getStringExtra("NUMERO")
        var pontuacao = intent?.getStringExtra("PONTUACAO")


        if (resultado.equals("Perdeu!")){
            this.tvSituacao.setText("Perdeu!")
            this.layout.setBackgroundColor(Color.RED)
        }

        if (resultado.equals("Ganhou!")) {
            this.tvSituacao.setText("Ganhou!")
            this.layout.setBackgroundColor(Color.GREEN)
        }

        this.tvNumero.setText(numero)
        this.tvPt.setText(pontuacao)


    }

}
