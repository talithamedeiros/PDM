package br.com.valeriacavalcanti.rateio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var etValor: EditText
    lateinit var etQtde: EditText
    lateinit var tvResultado: TextView
    lateinit var btCalcular: Button
    lateinit var btLimpar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etValor = findViewById(R.id.etMainValor) as EditText
        this.etQtde = findViewById(R.id.etMainQuantidade) as EditText
        this.tvResultado = findViewById(R.id.tvMainResultado) as TextView

        this.btCalcular = findViewById(R.id.btnMainCalcular) as Button
        this.btCalcular.setOnClickListener({ calcular(it) })

        this.btLimpar = findViewById(R.id.btnMainLimpar) as Button
        this.btLimpar.setOnClickListener({ limpar(it) })
    }

    fun calcular(view: View){
        var valor = this.etValor.text.toString().toFloat()
        var qtde = this.etQtde.text.toString().toInt()
        var resultado = valor/qtde

        this.tvResultado.setText(resultado.toString())
    }

    fun limpar(view: View){
        this.etValor.setText("")
        this.etQtde.setText("")
        this.tvResultado.setText("")
    }
}
