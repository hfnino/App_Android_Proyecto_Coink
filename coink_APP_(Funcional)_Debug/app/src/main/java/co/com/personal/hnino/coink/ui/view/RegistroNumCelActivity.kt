package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
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
        finish() // finaliza la actividad actual
    }

    fun presionarNum(view: View){
        // Esta función es util para mostrar el numero celular correspondiente, y que esta asociado a
        // los botones del teclado numerico en la pantalla de registro del numero celular del usuario.
        // el llamado onClickListener esta configurado directamente en la configuración XML de cada
        // botón en el fichero activity_registro_numero_cel.xml

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

        println(" ============> " + editTextNumCelStr) // Prueba de Escritorio

        if(editTextNumCelStr.length == 10){
            btnCheckOk.setBackgroundResource(R.drawable.boton_redondo_chulo_ok) // si se cumple la condición,
            // entonces aplicamos un nuevo recurso R.drawable como background
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

        //EL sistema debera conectar al backend y enviar mensaje de texto al usuario con un código, que el usuario deberá
        // introducir en la app coink, de tal manera que se pueda certificar que el número celular introducido es correcto.

        if(editTextNumCelStr.length == 10){
            verRegistroInfoUserActivity()
            UserDataAppProvider.userDataApp.numCelular = editTextNumCelStr
            /*
            Toast.makeText(this, " --- El número celular ingresado fue: " +
                    UserDataAppProvider.userDataApp.numCelular + "Validación OK",
                Toast.LENGTH_LONG).show() // prueba de escritorio

             */

        }
        else{
            Toast.makeText(this, " --- Por favor verifique su Numero de Celular ---", Toast.LENGTH_LONG).show()
        }
    }

    fun verRegistroInfoUserActivity(){

        val intent = Intent(this, RegistroInfoUserActivity::class.java)
        startActivity(intent)
        finish() // finaliza la actividad actual
    }
}