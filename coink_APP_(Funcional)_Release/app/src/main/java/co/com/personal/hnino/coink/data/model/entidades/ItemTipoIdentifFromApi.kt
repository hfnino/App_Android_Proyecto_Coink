package co.com.personal.hnino.coink.data.model.entidades

import com.google.gson.annotations.SerializedName

data class ItemTipoIdentifFromApi (
    @SerializedName("id") val id: Int,
    @SerializedName("notation") val notation: String,
    @SerializedName("description") val descripcion: String
)