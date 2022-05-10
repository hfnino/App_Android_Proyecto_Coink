package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ItemTipoGeneroApiClientInterface { // Al ser una interfaz, no se le puede poner un @Inject constructor() para que se pueda
    //inyectar en otras clases. para resolver este problema se creo el modulo NetworkModuleProvider donde se creo la función
    // provideItemTipoGeneroApiClient que con ayuda de la etiqueta @Providers retorna un objeto de tipo ItemTipoGeneroApiClientInterface
    // significa que si en cualquier clase necesitamos una instacia de interfaz ItemTipoGeneroApiClientInterface, simplemente la
    // inyectamos, y Dagger Hilt va a buscar y a encontrar a esta funcion, que retorna un objeto de ItemTipoGeneroApiClientInterface
    // y la va a proveer.

    //En esta inrterface, creamos los metodos abstractos que necesitamos para consumir los servicios API requeridos

    @GET
    suspend fun getApiItemTipoGenero(@Url url:String): Response<List<ItemTipoGeneroFromApi>> // este metodo nos permite acceder
    // al servicio de nuestra API por medio de peticiones GET y debe ser de tipo suspend ya que se usa en una
    // corrutina (hilo diferente al principal)
}