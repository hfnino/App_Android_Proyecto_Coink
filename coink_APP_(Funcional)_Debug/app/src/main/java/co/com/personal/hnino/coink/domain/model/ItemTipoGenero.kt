package co.com.personal.hnino.coink.domain.model

import co.com.personal.hnino.coink.data.model.entidades.ItemTipoGeneroFromApi

// Este es el modelo de datos final con el que la UI y dominio van a trabajar, de tal forma que si hay que
// cambiar el modelo de datos la base de datos, o de Retrifit no va a pasar nada ya que son modelos de
// datos independientes y la información que llegue al dominio va a ser siempre este modelo de datos

data class ItemTipoGenero(
    val id: Int,
    val name: String,
    val description: String
)

fun ItemTipoGeneroFromApi.converterToItemTipoGenro() : ItemTipoGenero {  //Función de extensión util para la funcionalidad del maper
    val itemTipoGenero: ItemTipoGenero = ItemTipoGenero(
        id = id,
        name = name,
        description = descripcion
    ) // los parametros azules son los asociados a esta misma clase, y los morados, son los asociados
    // a al objeto de la clase ItemTipoGeneroFromApi, lo anterior debido
    // a que estamos trabajando con una funsión de extensión de la clase ItemTipoGeneroFromApi
    return itemTipoGenero
}