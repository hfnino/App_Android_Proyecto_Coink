package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TiposIdentifService @Inject constructor(private val apiTiposIdentif: ItemTipoIdentifApiClientInterface) {

    suspend fun getListItemsTiposIdentifRetrofitApiClientInterface(queryByKeyWords:String): List<ItemTipoIdentifFromApi> {

        return withContext(Dispatchers.IO) {

            val respuesta = apiTiposIdentif.getApiItemTipoIdentif("documentTypes?apiKey=$queryByKeyWords")

            val respuestaItemsTiposIndetifFromApi = respuesta.body()
            val respuestaItemsTiposIndetifFromApiAux = respuestaItemsTiposIndetifFromApi ?: emptyList<ItemTipoIdentifFromApi>()

            respuestaItemsTiposIndetifFromApiAux
        }
    }
}