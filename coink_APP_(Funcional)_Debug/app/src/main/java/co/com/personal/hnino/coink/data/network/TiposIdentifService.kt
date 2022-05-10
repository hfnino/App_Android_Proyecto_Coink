package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TiposIdentifService @Inject constructor(private val apiTiposIdentif: ItemTipoIdentifApiClientInterface) { // Con @Inject constructor(),
    // estamos preparando  esta clase (que no es una activity ni view Models) para que pueda ser inyectada en otras clases y tambien la
    // preparamos para que se le pueda inyectar dependencias de otras clases que van a ser gestionadas por Dagger Hilt.
    // ------------ Con apiTiposIdentif: ItemTipoIdentifApiClientInterface  estamos inyectando una dependencia de la interface ItemTipoIdentifApiClientInterface,
    // y al ser una interface, Dagger hilt va a saber que no es una dependencia de las faciles de proveer y va a ir a buscar automaticamente una
    // funcion que este en algun modulo que tenga la etiqueta @Providers y que provea un objeto de la interface ImgsApolloAPIClientInteface y
    // dicha funcion la va a encontrar en el modulo que creamos llamado NetworkModuleProvider y esa funcion es la que llamamos
    // provideItemTipoIdentifApiClient y que nos provee un objeto de la interfaz ImgsApolloAPIClientInteface el cual ya nos retorna un retrofit
    // mesclado con la interfaz,es decir ya viene el retrofit completo, por lo que podemos usar la variable apiTiposIdentif en lugar de
    // retrofit.create(ImgsApolloAPIClientInteface::class.java).

    suspend fun getListItemsTiposIdentifRetrofitApiClientInterface(queryByKeyWords:String): List<ItemTipoIdentifFromApi> { // Se usa suspend por que se esta trabajando
        // con corrutinas

        return withContext(Dispatchers.IO) {
            // El codigo existente dentro de esta coorutina se va a ejecutar en un hilo secundario, es decir en un
            //hilo diferente al principal y retorna el resultado de tipo List<ItemTipoIdentifFromApi>

            val respuesta = apiTiposIdentif.getApiItemTipoIdentif("documentTypes?apiKey=$queryByKeyWords")//La variable
            //respuesta es la respuesta de tipo Response<List<ItemTipoIdentifFromApi>> que obtenemos de la API en Json. el String contenido en queryByKeyWords" se
            // lo agregamos al final de la URL base que configuramos en la función NetworkModuleProvider.provideTiposIdentifRetrofit() en
            // .baseUrl("https://api.bancoink.biz/qa/signup/") ------------- apiTiposIdentif que es de tipo interface ItemTipoIdentifApiClientInterface (se inyecto esta dependencia),
            // al ser una interface, Dagger hilt va a saber que no es una dependencia de las faciles de proveer y va a ir a buscar automaticamente
            // una funcion que este en algun modulo que tenga la etiqueta @Providers y que provea un objeto de la interface
            // ItemTipoIdentifApiClientInterface y dicha funcion la va a encontrar en el modulo que creamos llamado NetworkModuleProvider
            // y esa funcion es la que llamamos provideItemTipoIdentifApiClient y que nos provee un objeto de la interfaz ItemTipoIdentifApiClientInterface
            // el cual ya nos retorna un retrofit mesclado con la interfaz,es decir ya viene el retrofit completo,
            //  por lo que podemos usar la variable apiTiposIdentif en lugar de retrofit.create(ItemTipoIdentifApiClientInterface::class.java).

            val respuestaItemsTiposIndetifFromApi = respuesta.body()
            val respuestaItemsTiposIndetifFromApiAux = respuestaItemsTiposIndetifFromApi ?: emptyList<ItemTipoIdentifFromApi>()  // emptyList aplica Si la petición
            // falla, retornara una lista de objetos de tipo ItemTipoIdentifFromApi pero vacia.

            respuestaItemsTiposIndetifFromApiAux
        }
    }


}