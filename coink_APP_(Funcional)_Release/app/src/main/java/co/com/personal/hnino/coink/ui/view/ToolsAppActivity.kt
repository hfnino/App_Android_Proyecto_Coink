package co.com.personal.hnino.coink.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import co.com.personal.hnino.coink.R
import co.com.personal.hnino.coink.data.model.UserDataAppProvider
import com.google.android.material.button.MaterialButton

class ToolsAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_app)

        init()
    }

    fun init() {

        var textView_Num_Cel: TextView = findViewById(R.id.textView_Num_Cel)
        var textViewTDD: TextView = findViewById(R.id.textView_TDD)
        var textViewNDD: TextView = findViewById(R.id.textView_NDD)
        var textViewFEXD: TextView = findViewById(R.id.textView_FEXD)
        var textViewFDN: TextView = findViewById(R.id.textView_FDN)
        var textViewGEN: TextView = findViewById(R.id.textView_GEN)
        var textViewCE: TextView = findViewById(R.id.textView_CE)
        var textViewPSG: TextView = findViewById(R.id.textView_PSG)
        var textViewAC: TextView = findViewById(R.id.textView_AC)


        var btnCerrarApp: MaterialButton = findViewById(R.id.btnCerrarApp)

        textView_Num_Cel.setText("Número Celular: " +  UserDataAppProvider.userDataApp.numCelular)
        textView_Num_Cel.setText("Número Celular: " +  UserDataAppProvider.userDataApp.numCelular)
        textViewTDD.setText("Tipo de documento: " +  UserDataAppProvider.userDataApp.tipoDocumento)
        textViewNDD.setText("Número de documento: " +  UserDataAppProvider.userDataApp.numDocumento)
        textViewFEXD.setText("Fecha de expedición del documento: " +  UserDataAppProvider.userDataApp.fechaExpDocumento)
        textViewFDN.setText("Fecha de nacimiento: " +  UserDataAppProvider.userDataApp.fechaNacim)
        textViewGEN.setText("Genero: " +  UserDataAppProvider.userDataApp.tipoGenero)
        textViewCE.setText("Correo electrónico: " +  UserDataAppProvider.userDataApp.correE)
        textViewPSG.setText("PIN de seguridad: " +  UserDataAppProvider.userDataApp.pinSeg)
        textViewAC.setText("He leído ya acepto el contrato: " +  UserDataAppProvider.userDataApp.aceptaContrato)

        btnCerrarApp.setOnClickListener {
            finish()
        }
    }
}