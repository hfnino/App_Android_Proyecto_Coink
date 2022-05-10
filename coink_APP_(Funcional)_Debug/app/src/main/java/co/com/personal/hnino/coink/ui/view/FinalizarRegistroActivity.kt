package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import co.com.personal.hnino.coink.R
import co.com.personal.hnino.coink.data.model.UserDataAppProvider.Companion.userDataApp
import co.com.personal.hnino.coink.data.model.entidades.UserDataApp
import com.google.android.material.checkbox.MaterialCheckBox

class FinalizarRegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar_registro)

        init()
    }

    fun init(){

        var checkboxAceptarContrato: MaterialCheckBox = findViewById(R.id.checkboxAceptarContrato)
        var btnAceptar: AppCompatButton = findViewById(R.id.btnAceptar)

        checkboxAceptarContrato.setOnClickListener {
            if(checkboxAceptarContrato.isChecked){

                userDataApp.aceptaContrato = true
                btnAceptar.isEnabled = true
                btnAceptar.setTextColor(resources.getColor(R.color.verde_2))
            }else{
                userDataApp.aceptaContrato = false
                btnAceptar.isEnabled = false
                btnAceptar.setTextColor(resources.getColor(R.color.gris_80))
            }
        }

        btnAceptar.setOnClickListener {
            verBienvenidaActivity()
        }
    }

    fun verBienvenidaActivity(){

        val intent = Intent(this, BienvenidaActivity::class.java)
        startActivity(intent)
        finish() // finaliza la actividad actual

    }
}