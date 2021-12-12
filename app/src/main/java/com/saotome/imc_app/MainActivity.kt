package com.saotome.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.saotome.imc_app.databinding.ActivityMainBinding
import java.util.*

//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /*
    O pacote Synthetic foi deprecado! Usa-se agora o Binding
    https://developer.android.com/topic/libraries/view-binding/migration#kts
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        //Log.w("lifecycle","Entrei no CREATE - criando a tela")
        // atalho do onCreate direto para o onDestoy
        //finish()
        setListeners()
    }

    private fun setListeners () {
        binding.alturaEDT?.doAfterTextChanged { text ->
            Toast.makeText(this, "${text.toString()}", Toast.LENGTH_SHORT).show()
        }
        binding.pesoEDT?.doOnTextChanged { text, start, before, count ->  
            binding.titleTXT?.text = text
        }

        binding.calcularBTN?.setOnClickListener {
            CalcularIMC(altura = binding.alturaEDT?.text.toString(), peso = binding.pesoEDT?.text.toString())
        }
    }

    private fun CalcularIMC (peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        var altura = altura.toFloatOrNull()

        if (peso != null && altura != null ) {
            altura /= 100
            val imc = peso / (altura * altura)
            val local = Locale("pt", "BR")
            binding.titleTXT.text = "Meu IMC é: %.2f".format(local, imc)
        }
    }

    /*
    override fun onStart() {
        super.onStart()
        Log.w("lifecycle","Entrei no START - tornando a tela visível")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle","Entrei no RESUME - tornando a tela interativa")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle","PAUSE - a tela perdeu o foco e a interatividade")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle","STOP - a tela não está mais visível, mas ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle","\nEntrei no RESTART - a tela invisível está retornando ao foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle","Entrei no DESTROY - a tela foi destruida")
    }
    */

}