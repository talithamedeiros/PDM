package com.example.talithamedeiros.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CarregadorReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //throw UnsupportedOperationException("Not yet implemented")

        val msg = when(intent.action){
            Intent.ACTION_TIME_TICK -> "Hora mudou!"
            else -> "Deu errado!"
        }

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}