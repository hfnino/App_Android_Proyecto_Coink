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

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario: Calendar = Calendar.getInstance()
        val day = calendario.get(Calendar.DAY_OF_MONTH)
        val month = calendario.get(Calendar.MONTH)
        val year = calendario.get(Calendar.YEAR)
        val fechActualMiliseg = calendario.timeInMillis

        val datePickerDialog = DatePickerDialog(activity as Context, R.style.datePickerTheme, this, year, month, day)

        datePickerDialog.datePicker.maxDate = fechActualMiliseg - 315360000000
        datePickerDialog.datePicker.minDate = fechActualMiliseg - 3153600000000

        return datePickerDialog
    }
}