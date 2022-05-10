package co.com.personal.hnino.coink.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel // Con esta etiqueda, preparamos clases de tipo  view Model como sucede en este caso, y lo hacemos con el fin de que sea posible
// inyectarle las dependencias necesarias que van a ser gestionadas por Dagger Hilt
class StartAppViewModel @Inject constructor(): ViewModel()  {

    var isLoading = MutableLiveData<Boolean>() // Esta variable de tipo LiveData Boolean nos ayudar a mostrar u ocultar la ballra circular de progreso cuando
    // el sistema esta conectandose a la API para traer la información del Backend

    fun sleepPantallaInicio(){
        Log.d(" ==================================> thread C ==> ",Thread.currentThread().name)

        isLoading.postValue(true) // Muestra barra circular de progreso ------ la variable isLoading que es de tipo LiveData Boolean
        // se da cuenta que le hicimos un cambio y avisara a la activity y/o Fragment correspondiente y este ultimo va a hacer lo que crea conveniente.
        // Si no usaramos Live Data, tendriamos que configurar esta funcion para que retorne
        // el objeto la variable "isLoading" a la vista donde esta funcion fue llamada.

        Thread.sleep(4000)

        isLoading.postValue(false) // Oculta barra circular de progreso

    }
}