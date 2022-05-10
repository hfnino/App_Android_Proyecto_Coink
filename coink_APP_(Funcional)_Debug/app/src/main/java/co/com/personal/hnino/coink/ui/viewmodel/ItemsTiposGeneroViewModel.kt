package co.com.personal.hnino.coink.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.personal.hnino.coink.domain.GetListItemsTiposGeneroUseCase
import co.com.personal.hnino.coink.domain.model.ItemTipoGenero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Con esta etiqueda, preparamos clases de tipo  view Model como sucede en este caso, y
// lo hacemos con el fin de que sea posible inyectarle las dependencias necesarias que van a ser
// gestionadas por Dagger Hilt
class ItemsTiposGeneroViewModel @Inject constructor(
    private var getListItemsTiposGeneroUseCase: GetListItemsTiposGeneroUseCase
): ViewModel() {

    val listItemsTiposGeneroMLD = MutableLiveData<List<ItemTipoGenero>>()

    var isLoading = MutableLiveData<Boolean>() // Esta variable de tipo LiveData Boolean nos ayuda a mostrar u ocultar la barra
    // circular de progreso cuando el sistema esta conectandose a la API para traer la información del Backend

    fun getListItemsTiposGenero (queryByKeyWords: String){

        viewModelScope.launch {
            isLoading.postValue(true) // Muestra barra circular de progreso ------ la variable isLoading que es de tipo LiveData Boolean
            // se da cuenta que le hicimos un cambio y avisara a la activity y/o Fragment correspondiente y este ultimo va a hacer lo que crea conveniente.
            // Si no usaramos Live Data, tendriamos que configurar esta funcion para que retorne
            // el objeto la variable "isLoading" a la vista donde esta funcion fue llamada.

            println("-----------------en corrutina-------- => " + queryByKeyWords) // Prueba de Escritorio
            val respuestaListaItemTipoGeneroFromApi = getListItemsTiposGeneroUseCase(queryByKeyWords) // no se requiere
            // llamar ningun metodo de clase, ya que se esta usando el operador invoke

            if(! respuestaListaItemTipoGeneroFromApi.isNullOrEmpty()){
                listItemsTiposGeneroMLD.postValue(respuestaListaItemTipoGeneroFromApi!!) //Muestra error, pero al parecer es algún bug de Android
                // ya que la app funciona correctamente.

                isLoading.postValue(false) // Oculta barra circular de progreso
            }
            else{
                println(" ==============================> Verificar el caso, ya que la respuesta debio ser una lista de objetos de tipo" +
                        " ItemTipoGenero, y en su lugar, se obtuvo como respuesta un null, Por favor verifique que tenga acceso a Internet" +
                        " o en su defecto pueda ser fallas en el servidor.") // Prueba de Escritorio

                isLoading.postValue(false)
            }
        }
    }
}