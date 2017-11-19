package com.example.talithamedeiros.servicolista

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var lista: ListView
    var servicos = arrayListOf<String>("Browser", "Discar", "Ligar", "Enviar e-mail", "Enviar SMS",
            "Compartilhar Texto", "Visualizar ponto no mapa", "Visualizar rota no mapa", "Abrir vídeo do YouTube", "Tirar Foto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.carregarItensLista()
        this.clickItensLista()

    }

    fun carregarItensLista(){
        this.lista = findViewById(R.id.lista)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicos)
        this.lista.adapter = adapter
    }

    fun clickItensLista(){
        this.lista.setOnItemClickListener({parent, view, position, id ->
            if (this.servicos[position].equals("Browser")) {
                val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
                val it = Intent(Intent.ACTION_VIEW, uri)
                startActivity(it)
            }

            if (this.servicos[position].equals("Discar")) {
                val uri = Uri.parse("tel:1234567")
                val it = Intent(Intent.ACTION_DIAL, uri)
                startActivity(it)
            }

            if (this.servicos[position].equals("Ligar")) {
                val uri = Uri.parse("tel:1234567")
                val it = Intent(Intent.ACTION_CALL, uri)

                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    //startActivity(it)
                }
            }

            if (this.servicos[position].equals("Enviar e-mail")) {
                val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
                val it = Intent(Intent.ACTION_SENDTO, uri)
                it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
                it.putExtra(Intent.EXTRA_TEXT, "Texto")
                startActivity(it)
            }

            if (this.servicos[position].equals("Enviar SMS")) {
                val uri = Uri.parse("sms:1234567")
                val it = Intent(Intent.ACTION_SENDTO, uri)
                it.putExtra("sms_body", "Mensagem")
                startActivity(it)
            }

            if (this.servicos[position].equals("Compartilhar Texto")) {
                val it = Intent(Intent.ACTION_SEND)
                it.setType("text/plain")
                it.putExtra(Intent.EXTRA_TEXT, "Texto")
                startActivity(Intent.createChooser(it, "Compartilhar"))

            }

            if (this.servicos[position].equals("Visualizar ponto no mapa")) {
                val uri = Uri.parse("geo:-7.1356496,-34.8760932")
                val it = Intent(Intent.ACTION_VIEW, uri)
                startActivity(it)

            }

            if (this.servicos[position].equals("Visualizar rota no mapa")) {
                val origem = "-7.1356496,-34.8760932"
                val destino = "-71181836,-34.8730402"

                val uri = Uri.parse("http://maps.google.com/maps?f=&saddr=${origem}+&daddr${destino}")
                val it = Intent(Intent.ACTION_VIEW, uri)

                startActivity(it)
            }

            if (this.servicos[position].equals("Abrir vídeo do YouTube")) {
                val uri = Uri.parse("vnd.youtube://H0Z7ewOXCKw")
                val it = Intent(Intent.ACTION_VIEW, uri)
                startActivity(it)
            }

            if (this.servicos[position].equals("Tirar Foto")) {
                val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(it)
            }
        })
    }

}
