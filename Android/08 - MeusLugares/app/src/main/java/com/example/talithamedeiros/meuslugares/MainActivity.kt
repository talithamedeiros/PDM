package com.example.talithamedeiros.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btRegistrar : Button
    lateinit var btTirarFoto : Button
    lateinit var btProximo : Button
    lateinit var etNome : EditText
    lateinit var etDescricao : EditText
    lateinit var gpsManager: LocationManager
    lateinit var gpsListener: LocationListener
    lateinit var ivImagem : ImageView
    var lista = arrayListOf<Lugar>()

    var FOTO = 1
    var coordenadas = ""

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etNome = findViewById(R.id.etMainNome)
        this.etDescricao = findViewById(R.id.etMainDescricao)
        this.ivImagem = findViewById(R.id.ivMainImagem)

        this.btRegistrar = findViewById(R.id.btMainRegistrar)
        this.btRegistrar.setOnClickListener( { registrarLocal(it)} )

        this.btProximo = findViewById(R.id.btMainProximo)
        this.btProximo.setOnClickListener( { proximo(it)} )

        this.btTirarFoto = findViewById(R.id.btMainTirarFoto)
        this.btTirarFoto.setOnClickListener( { tirarFoto(it)} )

        this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        this.gpsListener = GPSListener()
        this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this.gpsListener)
    }

    override fun onStop() {
        super.onStop()
        this.gpsManager.removeUpdates(this.gpsListener)
    }

    fun tirarFoto(view: View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it, FOTO)
    }

    fun registrarLocal(view: View){

        val lugar = Lugar((this.ivImagem.drawable as BitmapDrawable).bitmap, this.etNome.text.toString(),
                this.etDescricao.text.toString(),this.coordenadas, Date())

        lista.add(lugar)

        this.etNome.text.clear()
        this.etDescricao.text.clear()

        this.etNome.requestFocus()

    }

    fun proximo(view: View){
        val it = Intent(this, ListaActivity::class.java)
        it.putExtra("REGISTRO", lista)
        startActivity(it)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FOTO) {
            this.ivImagem.setImageBitmap(data?.extras?.get("data") as Bitmap)
        }

    }

    inner class GPSListener: LocationListener{

        override fun onLocationChanged(location: Location?) {
            this@MainActivity.coordenadas = "${location?.latitude} - ${location?.longitude}"
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
