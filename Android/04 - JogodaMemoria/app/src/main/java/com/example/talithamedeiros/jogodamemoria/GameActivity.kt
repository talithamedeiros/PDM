package com.example.talithamedeiros.jogodamemoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.GridLayout
import android.widget.ImageView
import java.util.*

class GameActivity : AppCompatActivity() {
    lateinit var layout: GridLayout
    var imagens = arrayListOf(R.drawable.imagem1, R.drawable.imagem2, R.drawable.imagem3, R.drawable.imagem4,
            R.drawable.imagem5, R.drawable.imagem6, R.drawable.imagem7, R.drawable.imagem8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        this.layout = findViewById(R.id.layoutGame)

        imagens.addAll(imagens)
        Collections.shuffle(imagens)

        this.exibeImagens()
    }

    fun exibeImagens(){
        for (i in 0..15){
            val iv = ImageView(this)
            iv.id = i
            iv.setImageResource(R.drawable.fundo)
            iv.setOnClickListener({onClick(it)})
            this.layout.addView(iv)
        }
    }

    fun onClick(view: View){
        Log.i("APP","${(view as ImageView).id}" )
        Log.i("APP","${this.imagens[(view as ImageView).id]}" )

        (view as ImageView).setImageResource(this.imagens[(view as ImageView).id])
    }

}
