
App Android desarrollado en lenguaje  Kotlin donde se usa =>

CheckBox => Si
Clean Architecture => Si
Dagger Hilt para inyección de dependencias => Si
DatePicker (Selector de fecha) => SI
Mappers para convertir objetos de una clase a objetos de otra clase => Si
Jetpack Compose => No
Layout Activity => Si
Layout Fracment => No
XML Componets y Material Dising Componets =>

AppCompactButton Selector y shapes => Si
Button con Selector y shapes => Si
CardView => Si
GuideLine => Si
Icons  => Si
ImageView => Si
ImageButton con selector y shape => Si
MaterialButton => Si
ProgressBar => Si
TextView => Si
TextImputLayout con AutoCompleteTextView (dropdawn) => Si
TextImputLayout con TextInputEditText => Si
ScrollView => Si

MVVM Patrón de arquitectura con Live Data => Si
Picasso => No
Retrofit 2 y Corrutinas para Consumo de API => Si
Room (Libreria) para persistencia en base de datos local usando (Entitys, PrimaryKeys, ForeignKeys) => No
SearchView => No
Share Preferences => No
Splash Screen (Pantalla de bienvenida y recarga) => Si
Switch => No
Shimmer (Pantalla personalizada de carga para no usar los proggess Bar) => No
Testing (Pruebas unitarias) => No
View Binding => Si

//-------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------//

Prueba Desarrollador Android Nativo

Nota: Si por algún motivo el tiempo puede ser una limitación, intente resolver lo que considere que
es la parte más valiosa o importante del ejercicio. Si es el caso, describa como manejaría la o las
partes del ejercicio que no pudo desarrollar en el archivo README.md. Este ejercicio deberá ser 
entregado en los próximos 7 días después de su aceptación. Recomendamos entregar la solución lo más 
pronto posible para realizar la entrevista técnica.

Ejercicio

El objetivo de la presente prueba es desarrollar una aplicación en Android Nativo utilizando la API 
de Coink el objetivo es simular un registro exitoso en Coink.

La aplicación debería contar con lo siguiente:

-   Desarrollar la siguiente interfaz para la aplicación:  
    https://xd.adobe.com/view/2e4efd9b-575d-4d3d-9753-0fbb3eb3e2f9-7b1d/
    
-   El usuario debe ser capaz de navegar entre pantallas solamente cuando los datos introducidos por 
    el usuario son válidos.
    
-   Todos los campos de entrada deben validar los datos introducidos por el usuario y mostrar mensajes 
    de error útiles para entradas incorrectas.
    
-   Implementar un Spinner o Loader para el llamado de los servicios.

-   Recolecte los datos del usuario registrados en todo el flujo y muéstrelos en un log cuando 
    finalice el registro.

Se evaluará:

Calidad a nivel de código.
Patrones de diseño.
Uso de estilos y componentes visuales.

Consideraciones:

Manejar errores inesperados.

Los endpoints que deben ser integrados son los siguientes:
https://api.bancoink.biz/qa/signup/documentTypes?apiKey=030106
https://api.bancoink.biz/qa/signup/genders?apiKey=030106



Entrega
La entrega debe ser mediante un enlace a un repositorio público con las instrucciones para hacer 
la construcción (build) del proyecto, incluyendo el apk o paquete de la aplicación generada. 

