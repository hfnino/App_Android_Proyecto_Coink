package co.com.personal.hnino.coink.data.network

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ItemTipoIdentifApiClientInterface {

    @GET
    suspend fun getApiItemTipoIdentif(@Url url:String): Response<List<ItemTipoIdentifFromApi>>
}