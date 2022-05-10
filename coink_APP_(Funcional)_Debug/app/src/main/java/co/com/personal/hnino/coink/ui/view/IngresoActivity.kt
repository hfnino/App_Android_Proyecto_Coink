package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import co.com.personal.hnino.coink.R
import com.google.android.material.button.MaterialButton

class IngresoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)
        init()
    }

    fun init(){

        var buttonRegistrarse = findViewById<MaterialButton>(R.id.ButtonRegistrarse)
        var buttonIngresar = findViewById<MaterialButton>(R.id.ButtonIngresar)

        buttonRegistrarse.setOnClickListener {
            verNumeroCelActivity()
        }

        buttonIngresar.setOnClickListener {
            Toast.makeText(this, " --- Opción 'Ingresar' en Desarrollo ---", Toast.LENGTH_SHORT).show()
        }
    }

    fun verNumeroCelActivity(){

        val intent = Intent(this, RegistroNumCelActivity::class.java)
        startActivity(intent)
        finish()
    }
}