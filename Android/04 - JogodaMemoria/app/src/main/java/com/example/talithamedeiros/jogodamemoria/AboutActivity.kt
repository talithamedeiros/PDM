package com.example.talithamedeiros.jogodamemoria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    lateinit var btnVoltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        this.btnVoltar = findViewById(R.id.btnAboutVoltar)
        this.btnVoltar.setOnClickListener({clickVoltar(it)})
    }

    fun clickVoltar(view: View){
        val itent = Intent(this, MainActivity::class.java)
        startActivity(itent)
    }
}
