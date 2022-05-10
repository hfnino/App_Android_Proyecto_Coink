package co.com.personal.hnino.coink.ui.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.core.util.PatternsCompat
import androidx.lifecycle.Observer
import co.com.personal.hnino.coink.R
import co.com.personal.hnino.coink.data.model.UserDataAppProvider
import co.com.personal.hnino.coink.domain.model.ItemTipoGenero
import co.com.personal.hnino.coink.domain.model.ItemTipoIdentif
import co.com.personal.hnino.coink.ui.viewmodel.ItemsTiposGeneroViewModel
import co.com.personal.hnino.coink.ui.viewmodel.ItemsTiposIdentViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint  // Con esta etiqueta configuramos esta activity y la preparamos para que permita inyectar  dependencias
// haciendo uso de Dagger Hilt, Una dependencia es una clase que es necesario usar en otras clases, y para ello es necesario
// crear instancias de esas clases (dependencias), sin embargo al usar Dagger Hilt, lo que hacemos es inyectar las clases
// que necesitamos, y no nececitamos crear instancias de las mismas ya que Dagger Hilt hace esa labor cuando es requerido .
// La idea de implementar Inyección de dependencias es que dentro de una clase, no se tenga ninguna instacia de ninguna otra clase,
// ya que todas deberian ser inyectadas y gestionadas por Dagger Hilt

class RegistroInfoUserActivity : AppCompatActivity() {

    private lateinit var backActivity2: ImageView

    private lateinit var textFieldIds: TextInputLayout
    private lateinit var autoCompleteIds: AutoCompleteTextView
    private lateinit var listaItemsTiposIdentificacion: List<ItemTipoIdentif>
    private var itemsIds: MutableList<String> = mutableListOf()

    private lateinit var tilNumDocument: TextInputLayout
    private lateinit var tvNumDocument : TextInputEditText

    private lateinit var tilfechExpDoc: TextInputLayout
    private lateinit var tietfechExpDoc: TextInputEditText
    private lateinit var tilfechNacim: TextInputLayout
    private lateinit var tietfechNacim: TextInputEditText

    private lateinit var textFieldGen: TextInputLayout
    private lateinit var autoCompleteGen: AutoCompleteTextView
    private lateinit var listaItemsTiposGen: List<ItemTipoGenero>
    private var itemsGen: MutableList<String> = mutableListOf()

    private lateinit var tilCorreoE1 : TextInputLayout
    private lateinit var tietCorreoE1 : TextInputEditText
    private lateinit var tilCorreoE2 : TextInputLayout
    private lateinit var tietCorreoE2 : TextInputEditText
    private lateinit var tilPinSeg1: TextInputLayout
    private lateinit var tietPinSeg1 : TextInputEditText
    private lateinit var tilPinSeg2: TextInputLayout
    private lateinit var tietPinSeg2 : TextInputEditText

    private lateinit var btnSiguienteRegInfoUser: AppCompatButton

    private val itemsTiposIdentViewModel : ItemsTiposIdentViewModel by viewModels()// hacemos la conexion
    // y logica de nuestra viewModel a nuestra vista (activity y/o Fragment), incluyendo el ciclo de vida
    // y demas.
    private val itemsTiposGeneroViewModel : ItemsTiposGeneroViewModel by viewModels()// hacemos la conexion
    // y logica de nuestra viewModel a nuestra vista (activity y/o Fragment), incluyendo el ciclo de vida
    // y demas.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_info_user)

        init()
    }

    fun init() {

        backActivity2 = findViewById(R.id.backActivity2)
        tilNumDocument = findViewById(R.id.tilNumDocument)
        tvNumDocument = findViewById(R.id.tietNumDocument)
        tilfechExpDoc = findViewById(R.id.tilfechExpDoc)
        tietfechExpDoc = findViewById(R.id.tietfechExpDoc)
        tilfechNacim = findViewById(R.id.tilfechNacim)
        tietfechNacim = findViewById(R.id.tietfechNacim)
        tilCorreoE1 = findViewById(R.id.tilCorreoE1)
        tietCorreoE1 = findViewById(R.id.tietCorreoE1)
        tilCorreoE2 = findViewById(R.id.tilCorreoE2)
        tietCorreoE2 = findViewById(R.id.tietCorreoE2)
        tilPinSeg1 = findViewById(R.id.tilPinSeg1)
        tietPinSeg1 = findViewById(R.id.tietPinSeg1)
        tilPinSeg2 = findViewById(R.id.tilPinSeg2)
        tietPinSeg2 = findViewById(R.id.tietPinSeg2)



        btnSiguienteRegInfoUser = findViewById(R.id.btnSiguienteRegInfoUser)

        backActivity2.setOnClickListener {
            verNumeroCelActivity()
        }

        configTextFieldIds()

        tietfechExpDoc.setOnClickListener { showDatePickerFechExpDocDialog() }
        tietfechNacim.setOnClickListener { showDatePickerFechNacimDialog() }

        configTextFieldGen()


        tietPinSeg1.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Medodo para definir acciones antes de que cambie el texto contenido en el
                //TextInputEditText asociado a la variable tietPinSeg1. Para este ejercicio no lo
                //vamos a implementar.
                println(" ===================> EL metodo beforeTextChanged no tiene definido" +
                        "acciones para realizar antes de que cambie el texto contenido en " +
                        "TextInputEditText asociado a la variable tietPinSeg1 ")
            }

            override fun afterTextChanged(s: Editable?) {
                //Medodo para definir acciones despues de que cambie el texto contenido en el
                //TextInputEditText asociado a la variable tietPinSeg1. Para este ejercicio no lo
                //vamos a implementar.
                println(" ===================> EL metodo afterTextChanged no tiene definido" +
                        "acciones para realizar despues de que cambie el texto contenido " +
                        "en TextInputEditText asociado a la variable tietPinSeg1 ")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Medodo para definir acciones mientras  este cambiando el texto contenido en el
                //TextInputEditText asociado a la variable tietPinSeg1. Para este ejercicio Si lo
                //vamos a implementar ya que es el evento de escucha que necesitamos.

                if (tietPinSeg1.text.toString().length ==4){
                    btnSiguienteRegInfoUser.isEnabled = true
                    btnSiguienteRegInfoUser.setTextColor(resources.getColor(R.color.verde_2))
                }
                else{
                    btnSiguienteRegInfoUser.isEnabled = false
                    btnSiguienteRegInfoUser.setTextColor(resources.getColor(R.color.gris_80))
                }
            }
        })

        btnSiguienteRegInfoUser.setOnClickListener {
            validarUserData()
        }

    }

    private fun verNumeroCelActivity(){

        val intent = Intent(this, RegistroNumCelActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun configTextFieldIds() {

        textFieldIds = findViewById(R.id.textFieldIds)
        autoCompleteIds = findViewById(R.id.autoCompleteIds) // Dropdawn menu para mostrar desplegable
        // con las diferentes opciones de tipos de identificación

        itemsTiposIdentViewModel.getListItemsTiposIdentif("030106")

        itemsTiposIdentViewModel.listItemsTiposIdentifMLD.observe(this, Observer{ listaItemsTiposIdentif ->

            listaItemsTiposIdentificacion = listaItemsTiposIdentif

            println(" =============> Los items de Tipos de Identificación son => "
                    + listaItemsTiposIdentificacion.toString()) // Prueba de Escritorio

            listaItemsTiposIdentificacion.map {
                itemsIds.add(it.description)
            }

            itemsIds.add("Cedula de Extranjería")

            val adapterIds = ArrayAdapter(this@RegistroInfoUserActivity, R.layout.item_dropdawn,
                itemsIds)

            autoCompleteIds.setAdapter(adapterIds)

            autoCompleteIds.onItemClickListener = object :
                AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    UserDataAppProvider.userDataApp.tipoDocumento = itemsIds[position]
                    /*
                    Toast.makeText(this@RegistroInfoUserActivity, "Se ha seleccionado la opción => "
                            + UserDataAppProvider.userDataApp.tipoDocumento, Toast.LENGTH_SHORT).show() // Prueba de Escritorio

                     */
                }
            }
        })
    }

    private fun showDatePickerFechExpDocDialog() {
        val datePickerFechExpDoc = DatePickerFragment(){ day, month, year -> onDateSelectedFechExpDoc(day, month, year) }
        datePickerFechExpDoc.show(supportFragmentManager, "datePickerFechExpDoc")

    }

    fun onDateSelectedFechExpDoc (day: Int, month: Int, year: Int){
        tietfechExpDoc.setText("$day/$month/$year")
        UserDataAppProvider.userDataApp.fechaExpDocumento = "$day/$month/$year"
    }

    private fun showDatePickerFechNacimDialog() {
        val datePickerFechNacim = DatePickerFragment(){ day, month, year -> onDateSelectedFechNacim(day, month, year) }
        datePickerFechNacim.show(supportFragmentManager, "datePickerFechNacim")

    }

    fun onDateSelectedFechNacim (day: Int, month: Int, year: Int){
        tietfechNacim.setText("$day/$month/$year")
        UserDataAppProvider.userDataApp.fechaNacim = "$day/$month/$year"
    }

    private fun configTextFieldGen() {

        textFieldGen = findViewById(R.id.textFieldGen)
        autoCompleteGen = findViewById(R.id.autoCompleteGen) // Dropdawn menu para mostrar desplegable
        // con las diferentes opciones de tipos de genero

        itemsTiposGeneroViewModel.getListItemsTiposGenero("030106")

        itemsTiposGeneroViewModel.listItemsTiposGeneroMLD.observe(this, Observer{ listaItemsTiposGenero ->

            listaItemsTiposGen = listaItemsTiposGenero

            println(" =============> Los items de Tipos Genero son => "
                    + listaItemsTiposGenero.toString()) // Prueba de Escritorio

            listaItemsTiposGen.map {
                itemsGen.add(it.name)
            }

            val adapterGen = ArrayAdapter(this@RegistroInfoUserActivity, R.layout.item_dropdawn,
                itemsGen)

            autoCompleteGen.setAdapter(adapterGen)

            autoCompleteGen.onItemClickListener = object :
                AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    UserDataAppProvider.userDataApp.tipoGenero = itemsGen[position]
                    /*
                    Toast.makeText(this@RegistroInfoUserActivity, "Se ha seleccionado la opción => "
                            + UserDataAppProvider.userDataApp.tipoGenero, Toast.LENGTH_SHORT).show() // Prueba de Escritorio

                     */
                }
            }
        })
    }

    fun validarUserData(){
        //Validamos que todos los campos del foromulario esten diligenciados correctamente.

        var validador :Boolean = true
        var tvNumDocumentStr = tvNumDocument.text.toString()
        var tietCorreoE1Str = tietCorreoE1.text.toString()
        var tietCorreoE2Str = tietCorreoE2.text.toString()
        var tietPinSeg1Str = tietPinSeg1.text.toString()
        var tietPinSeg2Str = tietPinSeg2.text.toString()

        if(UserDataAppProvider.userDataApp.tipoDocumento == ""){
            validador = false
            textFieldIds.error = "Selecciona tu tipo de documento"
        }
        else{
            textFieldIds.error = null
        }
        //----------------------------------------------------------------------------//
        if(tvNumDocumentStr.isEmpty() || tvNumDocument.text.toString().length <= 4){
            validador = false
            tilNumDocument.error = "Este campo no puede estar vacio o tener menos de 5 números"
        }
        else{
            UserDataAppProvider.userDataApp.numDocumento = tvNumDocument.text.toString()
            tilNumDocument.error = null
        }
        //----------------------------------------------------------------------------//
        if(UserDataAppProvider.userDataApp.fechaExpDocumento == ""){
            validador = false
            tilfechExpDoc.error = "Este campo no puede estar vacio"
        }
        else{
            tilfechExpDoc.error = null
        }
        //----------------------------------------------------------------------------//
        if(UserDataAppProvider.userDataApp.fechaNacim == ""){
            validador = false
            tilfechNacim.error = "Este campo no puede estar vacio"
        }
        else{
            tilfechNacim.error = null
        }

        //----------------------------------------------------------------------------//
        if(UserDataAppProvider.userDataApp.tipoGenero == ""){
            validador = false
            textFieldGen.error = "Selecciona tu genero"
        }
        else{
            textFieldGen.error = null
        }
        textFieldGen
        //----------------------------------------------------------------------------//
        if(tietCorreoE1Str.isEmpty() ){
            validador = false
            tilCorreoE1.error = "Este campo no puede estar vacio"
        }
        else if(!PatternsCompat.EMAIL_ADDRESS.matcher(tietCorreoE1Str).matches()){
            // si es False (!), es por que el contenido de la variable tietCorreoE1Str no cumple con las validaciones
                // estandar de la sintaxis de un correo electronico
            validador = false
            tilCorreoE1.error = "Escriba un correo electrónico valido"
        }
        else{
            tilCorreoE1.error = null
        }
        //----------------------------------------------------------------------------//
        if(tietCorreoE2Str.isEmpty() ){
            validador = false
            tilCorreoE2.error = "Este campo no puede estar vacio"
        }
        else if(!PatternsCompat.EMAIL_ADDRESS.matcher(tietCorreoE2Str).matches()){
            // si es False (!), es por que el contenido de la variable tietCorreoE2Str no cumple con las validaciones
            // estandar de la sintaxis de un correo electronico
            validador = false
            tilCorreoE2.error = "Escriba un correo electrónico valido"
        }
        else if(tietCorreoE1Str != tietCorreoE2Str){
            validador = false
            tilCorreoE2.error = "Los correos electrónicos no coinciden"
        }
        else{
            tilCorreoE2.setEndIconDrawable(R.drawable.ic_baseline_check_24)
            UserDataAppProvider.userDataApp.correE = tietCorreoE2Str
            tilCorreoE2 .error = null
        }
//----------------------------------------------------------------------------//
        if(tietPinSeg1Str.isEmpty() || tietPinSeg1Str.length <= 3){
            validador = false
            tilPinSeg1.error = "Este campo no puede estar vacio o tener menos de 4 números"
        }
        else{
            tilPinSeg1.error = null
        }
        //----------------------------------------------------------------------------//

        if(tietPinSeg2Str.isEmpty() || tietPinSeg1Str.length <= 3){
            validador = false
            tilPinSeg2.error = "Este campo no puede estar vacio o tener menos de 4 números"
        }

        else if(tietPinSeg1Str != tietPinSeg2Str){
            validador = false
            tilPinSeg2.error = "Este campo no coincide con el PIN"
        }
        else{
            UserDataAppProvider.userDataApp.pinSeg= tietPinSeg2Str.toInt()
            tilPinSeg2 .error = null
        }

        //----------------------------------------------------------------------------//
        if (validador){ // si es true
            verFinalizarRegistroActivity()
        }
    }

    fun verFinalizarRegistroActivity(){

        val intent = Intent(this, FinalizarRegistroActivity::class.java)
        startActivity(intent)
        finish() // finaliza la actividad actual

    }
}