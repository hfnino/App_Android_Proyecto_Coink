package co.com.personal.hnino.coink.domain.model

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi

data class ItemTipoGenero(
    val id: Int,
    val name: String,
    val description: String
)

fun ItemTipoGeneroFromApi.converterToItemTipoGenro() : ItemTipoGenero {
    val itemTipoGenero: ItemTipoGenero = ItemTipoGenero(
        id = id,
        name = name,
        description = descripcion
    )

    return itemTipoGenero
}