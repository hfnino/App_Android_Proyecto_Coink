package co.com.personal.hnino.coink.domain.model

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoIdentifFromApi

data class ItemTipoIdentif (
    val id: Int,
    val notation: String,
    val description: String
)

fun ItemTipoIdentifFromApi.converterToItemTipoIdentif() : ItemTipoIdentif {
    val itemTipoIdentif: ItemTipoIdentif = ItemTipoIdentif(
        id = id,
        notation = notation,
        description = descripcion
    )

    return itemTipoIdentif
}