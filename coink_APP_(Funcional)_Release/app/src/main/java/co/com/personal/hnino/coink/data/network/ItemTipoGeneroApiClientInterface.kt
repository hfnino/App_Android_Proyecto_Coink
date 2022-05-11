package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ItemTipoGeneroApiClientInterface {

    @GET
    suspend fun getApiItemTipoGenero(@Url url:String): Response<List<ItemTipoGeneroFromApi>>
}