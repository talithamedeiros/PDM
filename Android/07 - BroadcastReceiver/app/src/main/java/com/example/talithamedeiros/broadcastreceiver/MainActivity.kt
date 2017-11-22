package com.example.talithamedeiros.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var receiver: CarregadorReceiverInterno
    lateinit var filter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.receiver = CarregadorReceiverInterno()

        this.filter = IntentFilter()
        this.filter.addAction(Intent.ACTION_TIME_TICK)
    }

    override fun onResume() {
        super.onResume()

        registerReceiver(this.receiver, this.filter)
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(this.receiver)
    }

    inner class CarregadorReceiverInterno: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val msg = when(intent?.action){
                Intent.ACTION_TIME_TICK-> "Hora mudou!"
                else -> "Eeeeeita"
            }
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
            val it = Intent(Intent.ACTION_VIEW, uri)
            startActivity(it)
        }
    }
}
