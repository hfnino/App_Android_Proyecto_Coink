package co.com.personal.hnino.coink.domain

import co.com.personal.hnino.coink.data.DataRepository
import co.com.personal.hnino.coink.domain.model.ItemTipoGenero
import javax.inject.Inject

class GetListItemsTiposGeneroUseCase @Inject constructor(
    private val repository: DataRepository
) {


    suspend operator fun invoke(queryByKeyWords:String): List<ItemTipoGenero>?{

        val listaItemTipoGenero = repository.getListaItemsTiposGeneroFromApi(queryByKeyWords)
        return listaItemTipoGenero
    }
}