package co.com.personal.hnino.coink.data.model.entidades

data class UserDataApp (
    var numCelular: String = "",
    var tipoDocumento: String = "",
    var numDocumento: String = "",
    var fechaExpDocumento: String = "",
    var fechaNacim: String = "",
    var tipoGenero: String = "",
    var correE: String = "",
    var pinSeg: Int = 0,
    var aceptaContrato: Boolean = false
        ) {
}