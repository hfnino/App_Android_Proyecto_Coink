package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi
import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TiposGeneroService @Inject constructor(private val apiTiposGenero: ItemTipoGeneroApiClientInterface) {

    suspend fun getListItemsTiposGeneroRetrofitApiClientInterface(queryByKeyWords:String): List<ItemTipoGeneroFromApi> {
        // Se usa suspend por que se esta trabajando con corrutinas

        return withContext(Dispatchers.IO) {
            // El codigo existente dentro de esta coorutina se va a ejecutar en un hilo secundario, es decir en un
            //hilo diferente al principal y retorna el resultado de tipo List<ItemTipoIdentifFromApi>

            val respuesta = apiTiposGenero.getApiItemTipoGenero("genders?apiKey=$queryByKeyWords")
            val respuestaItemsTiposGeneroFromApi = respuesta.body()
            val respuestaItemsTiposGeneroFromApiAux = respuestaItemsTiposGeneroFromApi ?: emptyList<ItemTipoGeneroFromApi>()
            // emptyList aplica Si la petición falla, retornara una lista de objetos de tipo ItemTipoGenerofFromApi pero vacia.

        respuestaItemsTiposGeneroFromApiAux
        }
    }
}