package com.example.talithamedeiros.servico

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btFoto : Button

    var REQUEST_FOTO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btFoto = findViewById(R.id.btFoto)
        this.btFoto.setOnClickListener({tirarFoto(it)})
    }

    fun tirarFoto(view : View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it, REQUEST_FOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_FOTO){
            val img = data?.extras
            val it = Intent (Intent.ACTION_SEND)
            it.setType("image/*")
            it.putExtra(Intent.EXTRA_STREAM, img)
            startActivity(it)
        }

    }
}
