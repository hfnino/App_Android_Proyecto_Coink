package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TiposGeneroService @Inject constructor(private val apiTiposGenero: ItemTipoGeneroApiClientInterface) {

    suspend fun getListItemsTiposGeneroRetrofitApiClientInterface(queryByKeyWords:String): List<ItemTipoGeneroFromApi> {

        return withContext(Dispatchers.IO) {

            val respuesta = apiTiposGenero.getApiItemTipoGenero("genders?apiKey=$queryByKeyWords")
            val respuestaItemsTiposGeneroFromApi = respuesta.body()
            val respuestaItemsTiposGeneroFromApiAux = respuestaItemsTiposGeneroFromApi ?: emptyList<ItemTipoGeneroFromApi>()

        respuestaItemsTiposGeneroFromApiAux
        }
    }
}