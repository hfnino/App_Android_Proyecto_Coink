package co.com.personal.hnino.coink.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.personal.hnino.coink.domain.GetListItemsTiposGeneroUseCase
import co.com.personal.hnino.coink.domain.model.ItemTipoGenero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsTiposGeneroViewModel @Inject constructor(
    private var getListItemsTiposGeneroUseCase: GetListItemsTiposGeneroUseCase
): ViewModel() {

    val listItemsTiposGeneroMLD = MutableLiveData<List<ItemTipoGenero>>()

    var isLoading = MutableLiveData<Boolean>()

    fun getListItemsTiposGenero (queryByKeyWords: String){

        viewModelScope.launch {
            isLoading.postValue(true)

            val respuestaListaItemTipoGeneroFromApi = getListItemsTiposGeneroUseCase(queryByKeyWords)

            if(! respuestaListaItemTipoGeneroFromApi.isNullOrEmpty()){
                listItemsTiposGeneroMLD.postValue(respuestaListaItemTipoGeneroFromApi)
            }
            else{
                isLoading.postValue(false)
            }
        }
    }
}