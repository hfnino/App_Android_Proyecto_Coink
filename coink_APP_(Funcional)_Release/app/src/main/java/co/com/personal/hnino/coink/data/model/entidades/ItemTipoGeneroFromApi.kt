package co.com.personal.hnino.coink.data.model.entidades

import com.google.gson.annotations.SerializedName

data class ItemTipoGeneroFromApi(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val descripcion: String
)