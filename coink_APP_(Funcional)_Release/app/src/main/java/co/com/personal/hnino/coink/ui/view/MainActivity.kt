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

    private lateinit var binding: ActivityMainBinding

    private val startAppViewModel : StartAppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init(){

        CoroutineScope(Dispatchers.IO).launch {
            startAppViewModel.sleepPantallaInicio()
        }

        startAppViewModel.isLoading.observe(this@MainActivity, Observer {

            binding.progressCircular.isVisible = it

            if (!binding.progressCircular.isVisible){
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