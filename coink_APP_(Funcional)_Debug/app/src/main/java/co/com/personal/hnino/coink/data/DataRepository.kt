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
) { // Con @Inject constructor(), estamos preparando esta clase
    // (que no es una activity ni view Models) para que pueda ser inyectada en otras clases y tambien la preparamos
    // para que se le pueda inyectar dependencias de otras clases que van a ser gestionadas por Dagger Hilt

    suspend fun getListaItemsTiposIdentifFromApi(queryByKeyWords:String): List<ItemTipoIdentif>{

        val respuestaListaItemTipoIdentifFromApi: List<ItemTipoIdentifFromApi> = apiTiposIdentif.getListItemsTiposIdentifRetrofitApiClientInterface(queryByKeyWords)

        val respuestaListaItemsTiposIdent: List<ItemTipoIdentif> = respuestaListaItemTipoIdentifFromApi.map { it.converterToItemTipoIdentif() } // La función .map es propia de
        //un List<XXXXX> y es como un bucle tipo For que para este caso nos es util para tomar cada uno de los objetos de tipo ItemTipoIdentifFromApi existentes
        // en la lista respuestaListaItemTipoIdentifFromApi y  convertirlos (Maper) a tipo ItemTipoIdentif, de esta manera, la variable respuestaListaItemsTiposIdent
        // resultara en una nueva lista, pero ahora con objetos de tipo ItemTipoIdentif

        return  respuestaListaItemsTiposIdent // Retornamos la lista de objetos de tipo ItemTipoIdentif
    }

    suspend fun getListaItemsTiposGeneroFromApi(queryByKeyWords:String): List<ItemTipoGenero>{

        val respuestaListaItemTipoGeneroFromApi: List<ItemTipoGeneroFromApi> = apiTiposGenero.getListItemsTiposGeneroRetrofitApiClientInterface(queryByKeyWords)

        val respuestaListaItemsTiposGenero: List<ItemTipoGenero> = respuestaListaItemTipoGeneroFromApi.map { it.converterToItemTipoGenro() }

        return  respuestaListaItemsTiposGenero // Retornamos la lista de objetos de tipo ItemTipoGenero
    }
}