package co.com.personal.hnino.coink.data.model.entidades

import com.google.gson.annotations.SerializedName

//Este es el modelo de datos que usaremos para trabajar con Retrofit de capturar toda la información
// asociada a los tipos de indentificacion por medio de la API

data class ItemTipoIdentifFromApi (
    @SerializedName("id") val id: Int,
    @SerializedName("notation") val notation: String,
    @SerializedName("description") val descripcion: String // desde la API se recibe
    // el parametro description pero el dato lo almacenamos en la variable 'descripcion', simplemente cambiamos el nombre
    // para que la aplicación sea mas facil de entender si asi fuera necesario, en este caso no era necesario, pero se
    //implemento para tener un ejemplo
)