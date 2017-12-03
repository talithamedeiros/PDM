package com.example.talithamedeiros.jogodamemoria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnJogar : Button
    lateinit var btnSobre : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnJogar = findViewById(R.id.btnMainJogar)
        this.btnSobre = findViewById(R.id.btnMainSobre)

        this.btnJogar.setOnClickListener({clickJogar(it)})
        this.btnSobre.setOnClickListener({clickSobre(it)})
    }

    fun clickJogar(view: View){
        val itent = Intent(this, GameActivity::class.java)
        startActivity(itent)
    }

    fun clickSobre(view: View){
        val itent = Intent(this, AboutActivity::class.java)
        startActivity(itent)
    }
}
