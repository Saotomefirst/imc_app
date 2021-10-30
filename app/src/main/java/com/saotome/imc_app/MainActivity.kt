package com.saotome.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle","Entrei no CREATE - criando a tela")
        // atalho do onCreate direto para o onDestoy
        //finish()
    }

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


}