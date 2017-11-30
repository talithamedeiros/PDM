package com.example.talithamedeiros.meuslugares

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {
    lateinit var tvNome : TextView
    lateinit var tvDescricao : TextView
    lateinit var tvCoordenadas : TextView
    lateinit var tvData : TextView
    lateinit var ivImagem : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        this.tvNome = findViewById(R.id.tvRegistroNome)
        this.tvDescricao = findViewById(R.id.tvRegistroDescricao)
        this.tvCoordenadas = findViewById(R.id.tvRegistroCoordenadas)
        this.tvData = findViewById(R.id.tvRegistroData)
        this.ivImagem = findViewById(R.id.ivRegistroFoto)

        var item = intent?.getParcelableExtra<Lugar>("ITEM")

        this.tvNome.setText(item?.nome)
        this.tvDescricao.setText(item?.descricao)
        this.tvCoordenadas.setText(item?.localizacao)
        this.tvData.setText(item?.data.toString())
        this.ivImagem.setImageBitmap(item?.imagem)

    }
}
