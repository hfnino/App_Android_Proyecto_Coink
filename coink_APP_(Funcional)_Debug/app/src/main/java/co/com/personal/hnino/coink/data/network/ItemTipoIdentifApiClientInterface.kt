package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ItemTipoIdentifApiClientInterface { // Al ser una interfaz, no se le puede poner un @Inject constructor() para que se pueda
    //inyectar en otras clases. para resolver este problema se creo el modulo NetworkModuleProvider donde se creo la función
    // provideItemTipoIdentifApiClient que con ayuda de la etiqueta @Providers retorna un objeto de tipo ItemTipoIdentifApiClientInterface
    // significa que si en cualquier clase necesitamos una instacia de interfaz ItemTipoIdentifApiClientInterface, simplemente la
    // inyectamos, y Dagger Hilt va a buscar y a encontrar a esta funcion, que retorna un objeto de ItemTipoIdentifApiClientInterface
    // y la va a proveer.

    //En esta inrterface, creamos los metodos abstractos que necesitamos para consumir los servicios API requeridos

    @GET
    suspend fun getApiItemTipoIdentif(@Url url:String): Response<List<ItemTipoIdentifFromApi>> // este metodo nos permite acceder al servicio de nuestra API
    //por medio de peticiones GET y debe ser de tipo suspend ya que se usa en una corrutina (hilo diferente al principal)
}