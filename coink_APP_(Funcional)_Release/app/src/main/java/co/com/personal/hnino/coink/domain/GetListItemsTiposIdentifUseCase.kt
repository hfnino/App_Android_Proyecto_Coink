package co.com.personal.hnino.coink.domain

import co.com.personal.hnino.coink.data.DataRepository
import co.com.personal.hnino.coink.domain.model.ItemTipoIdentif
import javax.inject.Inject

class GetListItemsTiposIdentifUseCase @Inject constructor(
    private val repository: DataRepository
    ) {

    suspend operator fun invoke(queryByKeyWords:String): List<ItemTipoIdentif>?{

        val listaItemTipoIdentif = repository.getListaItemsTiposIdentifFromApi(queryByKeyWords)
        return listaItemTipoIdentif
    }
}