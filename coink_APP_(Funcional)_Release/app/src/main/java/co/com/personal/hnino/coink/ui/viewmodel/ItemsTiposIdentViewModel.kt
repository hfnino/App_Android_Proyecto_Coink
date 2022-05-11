package co.com.personal.hnino.coink.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.personal.hnino.coink.domain.GetListItemsTiposIdentifUseCase
import co.com.personal.hnino.coink.domain.model.ItemTipoIdentif
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemsTiposIdentViewModel @Inject constructor(
    private var getListItemsTiposIdentifUseCase: GetListItemsTiposIdentifUseCase
): ViewModel() {

    val listItemsTiposIdentifMLD = MutableLiveData<List<ItemTipoIdentif>>()

    var isLoading = MutableLiveData<Boolean>()

    fun getListItemsTiposIdentif (queryByKeyWords: String){

        viewModelScope.launch {
            isLoading.postValue(true)

            val respuestaListaItemTipoIdentifFromApi = getListItemsTiposIdentifUseCase(queryByKeyWords)

            if(! respuestaListaItemTipoIdentifFromApi.isNullOrEmpty()){
                listItemsTiposIdentifMLD.postValue(respuestaListaItemTipoIdentifFromApi)

                isLoading.postValue(false)
            }
            else{
                isLoading.postValue(false)
            }
        }
    }
}