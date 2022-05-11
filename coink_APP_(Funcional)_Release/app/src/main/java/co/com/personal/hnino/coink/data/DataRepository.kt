package co.com.personal.hnino.coink.data

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi
import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import co.com.personal.hnino.coink.data.network.TiposGeneroService
import co.com.personal.hnino.coink.data.network.TiposIdentifService
import co.com.personal.hnino.coink.domain.model.ItemTipoGenero
import co.com.personal.hnino.coink.domain.model.ItemTipoIdentif
import co.com.personal.hnino.coink.domain.model.converterToItemTipoGenro
import co.com.personal.hnino.coink.domain.model.converterToItemTipoIdentif
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiTiposIdentif: TiposIdentifService,
    private val  apiTiposGenero: TiposGeneroService
) {

    suspend fun getListaItemsTiposIdentifFromApi(queryByKeyWords:String): List<ItemTipoIdentif>{

        val respuestaListaItemTipoIdentifFromApi: List<ItemTipoIdentifFromApi> = apiTiposIdentif.getListItemsTiposIdentifRetrofitApiClientInterface(queryByKeyWords)

        val respuestaListaItemsTiposIdent: List<ItemTipoIdentif> = respuestaListaItemTipoIdentifFromApi.map { it.converterToItemTipoIdentif() }

        return  respuestaListaItemsTiposIdent
    }

    suspend fun getListaItemsTiposGeneroFromApi(queryByKeyWords:String): List<ItemTipoGenero>{

        val respuestaListaItemTipoGeneroFromApi: List<ItemTipoGeneroFromApi> = apiTiposGenero.getListItemsTiposGeneroRetrofitApiClientInterface(queryByKeyWords)

        val respuestaListaItemsTiposGenero: List<ItemTipoGenero> = respuestaListaItemTipoGeneroFromApi.map { it.converterToItemTipoGenro() }

        return  respuestaListaItemsTiposGenero
    }
}