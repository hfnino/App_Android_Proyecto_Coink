package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import co.com.personal.hnino.coink.R
import co.com.personal.hnino.coink.data.model.UserDataAppProvider

class RegistroNumCelActivity : AppCompatActivity() {

    private var editTextNumCelStr: String = ""
    private lateinit var btnCheckOk : ImageButton
    private lateinit var editTextNumCel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_numero_cel)

        init()
    }

    fun init(){
        editTextNumCel = findViewById(R.id.editTextNumCel)
        btnCheckOk = findViewById(R.id.btmCheckOk)
        val backActivity: ImageView = findViewById(R.id.backActivity)

        backActivity.setOnClickListener {
            verIngresoActivity()
        }
        btnCheckOk.setOnClickListener {
            validarNumCel()
        }
    }

    fun verIngresoActivity(){

        val intent = Intent(this, IngresoActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun presionarNum(view: View){

        when(view.id){

            R.id.btnNum0 ->  validarLongitundNumCel("0")
            R.id.btnNum1 ->  validarLongitundNumCel("1")
            R.id.btnNum2 ->  validarLongitundNumCel("2")
            R.id.btnNum3 ->  validarLongitundNumCel("3")
            R.id.btnNum4 ->  validarLongitundNumCel("4")
            R.id.btnNum5 ->  validarLongitundNumCel("5")
            R.id.btnNum6 ->  validarLongitundNumCel("6")
            R.id.btnNum7 ->  validarLongitundNumCel("7")
            R.id.btnNum8 ->  validarLongitundNumCel("8")
            R.id.btnNum9 ->  validarLongitundNumCel("9")
            R.id.imagBackSpace ->  {
                if(editTextNumCelStr.isNotEmpty()) {
                    editTextNumCelStr = editTextNumCelStr.substring(0, editTextNumCelStr.length - 1)
                    editTextNumCel.setText(editTextNumCelStr)
                }
            }
        }

        if(editTextNumCelStr.length == 10){
            btnCheckOk.setBackgroundResource(R.drawable.boton_redondo_chulo_ok)
        }
        else{
            btnCheckOk.setBackgroundResource(R.drawable.boton_redondo_chulo)
        }
    }

    fun validarLongitundNumCel(numStr : String) {

        if (editTextNumCelStr.length < 10) {
            editTextNumCelStr += numStr
            editTextNumCel.setText(editTextNumCelStr)
        }
    }

    fun validarNumCel(){

        if(editTextNumCelStr.length == 10){
            verRegistroInfoUserActivity()
            UserDataAppProvider.userDataApp.numCelular = editTextNumCelStr
        }
        else{
            Toast.makeText(this, " --- Por favor verifique su Numero de Celular ---", Toast.LENGTH_LONG).show()
        }
    }

    fun verRegistroInfoUserActivity(){

        val intent = Intent(this, RegistroInfoUserActivity::class.java)
        startActivity(intent)
        finish()
    }
}