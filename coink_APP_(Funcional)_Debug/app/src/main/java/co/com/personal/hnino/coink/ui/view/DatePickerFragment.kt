package co.com.personal.hnino.coink.ui.view

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import co.com.personal.hnino.coink.R
import java.util.*

class DatePickerFragment (val listener: (day: Int, month: Int, year: Int) -> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener{
    // Esta clase recibe un parametro de función con los datos del día, mes, y año, También extiende
    // de DialogFragment(), y tambien implementa el metodo OnDateSetListener, la cual nos va a avisar
    // cuando seleccionemos una fecha en el calendario

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //Cuando el usuario seleccione una fecha, se va a llamar a este metodo onDateSet que recibe como
        //parametros el año, el mes, y el día que el usuario selecciono. Estos datos que capturamos
        //los regresamos por medio de la funcion listener siguiente hacia la activity correspondiente
        //donde se llamo a este Fragment, en este caso a la activity RegistroInfoUserActivity showDatePickerDialog()
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // usando la opción de Android Studio
        //Code -> Override Methods.. buscamos la función onCreateDialog y la sobreescribimos.

        val calendario: Calendar = Calendar.getInstance() // a la variable calendario le asignamos un
        //objeto de tpo Calendario, y de este objeto que instanciamos, podemos extraer el día actual,
        //la fecha actual, el año actual entre otras muchas opciones
        val day = calendario.get(Calendar.DAY_OF_MONTH) // obtenemos el día del mes actual.
        val month = calendario.get(Calendar.MONTH) // obtenemos el día del mes actual.
        val year = calendario.get(Calendar.YEAR) // obtenemos el año actual.
        val fechActualMiliseg = calendario.timeInMillis   // obtenemos la fecha actual en milisegundos
        // Los datos anteriores fueron obtenidos para ser mostrados al usuario como fecha deefault
        // antes de que selecione la fecha correspondiente.


        val datePickerDialog = DatePickerDialog(activity as Context, R.style.datePickerTheme, this, year, month, day)
        // creamos un objeto de tipo DatePickerDialog() que recibe varios parametos,
        // entre los cuales esta el contexto con el que no contamos, pero si contamos con
        // la activity que llamo a esta clase, por lo que podemos usar 'as' para convertir
        //esa activity a el contexto,tambien le configuramos un diseño y/o estilo 'R.style.datePickerTheme',
        // el cual creamos en el directorio res/values/themes.xml(nigth) llamado datePickerTheme,
        // tambien le pasamos el parametro del listener que se tiene que llamar
        //cuando el usario seleccione una fecha el cual es 'this' y que hace referencia a la función onDateSet
        //que tubimos que sobreescribir cuando implementamos DatePickerDialog.OnDateSetListener en
        //esta clase.
        datePickerDialog.datePicker.maxDate = fechActualMiliseg - 315360000000// configuramos la fecha maxima que puede
        // seleccionar el usuario, la cual se le debe pasar en milisegundos. fechActualMiliseg es la fecha actual
        // a la cual le restamos 315360000000 equivalentes a 10 años.
        datePickerDialog.datePicker.minDate = fechActualMiliseg - 3153600000000 // configuramos la fecha minima que puede
        // seleccionar el usuario, la cual se le debe pasar en milisegundos. fechActualMiliseg es la fecha actual
        // a la cual le restamos 3153600000000 equivalentes a 100 años.


        return datePickerDialog

    }
}