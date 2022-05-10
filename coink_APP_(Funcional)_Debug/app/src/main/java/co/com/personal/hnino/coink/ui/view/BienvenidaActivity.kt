package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.com.personal.hnino.coink.R
import com.google.android.material.button.MaterialButton

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        init()
    }

    fun init() {

        var btnContinuar: MaterialButton = findViewById(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            verToolsAppActivity()
        }
    }

    private fun verToolsAppActivity() {
        val intent = Intent(this, ToolsAppActivity::class.java)
        startActivity(intent)
        finish() // finaliza la actividad actual

    }
}