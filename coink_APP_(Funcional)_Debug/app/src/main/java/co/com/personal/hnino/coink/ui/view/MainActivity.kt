package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import co.com.personal.hnino.coink.databinding.ActivityMainBinding
import co.com.personal.hnino.coink.ui.viewmodel.StartAppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //Implementacion de view bindig

    private val startAppViewModel : StartAppViewModel by viewModels()// hacemos la conexion y logica de nuestra viewModel
    // a  la de nuestra vista (activity y/o Fragment), incluyendo el ciclo de vida y demas, ya no tenemos que hacer absolutamente nada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Implementacion de view bindig

        init()
    }

    fun init(){

        Log.d(" ==================================> thread A ==> ",Thread.currentThread().name) // Prueba de Escritorio

        CoroutineScope(Dispatchers.IO).launch {
            // El codigo existente dentro de esta coorutina se va a ejecutar en un hilo secundario, es decir en un
            //hilo diferente al principal
            Log.d(" ==================================> thread B ==> ",Thread.currentThread().name) // Prueba de Escritorio
            startAppViewModel.sleepPantallaInicio()
        }

        startAppViewModel.isLoading.observe(this@MainActivity, Observer {

            binding.progressCircular.isVisible = it // Muestra u oculta la barra circular de proceso
            Log.d(" ==================================> thread D ==> ",Thread.currentThread().name) // Prueba de Escritorio
            Log.d(" ==================================> valor  ==> ",it.toString()) // Prueba de Escritorio
            if (!binding.progressCircular.isVisible){ // Si es falso entonces =>

                verIngresoActivity()
            }
        })
        Toast.makeText(this, "... Cargando ...", Toast.LENGTH_SHORT).show()
    }


    fun verIngresoActivity(){

        val intent = Intent(this, IngresoActivity::class.java)
        startActivity(intent)
        finish()
    }
}