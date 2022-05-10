package co.com.personal.hnino.coink.data.modulosDI

import co.com.personal.hnino.coink.data.network.ItemTipoGeneroApiClientInterface
import co.com.personal.hnino.coink.data.network.ItemTipoIdentifApiClientInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Este modulo, nos va a proveer dependencias (necesario para usar inyección de dependencias con Dagger Hiil) que no son faciles de proveer, lo
//anterior teniendo en cuenta que las dependencias faciles de proveer son las de clases que nosotros creamos en nuestro proyecto por ejemplo una
// clase llamada personas que tiene varios atributos y que podemos habilitarla para ser inyectada  en otras clases con @Inyect constructor(),
// mientras que las que no son faciles de proveer son las dependencias de librerias como retrofit o dependencias de clases que contienen interfaces,
// a las cuales no podemos habilitarlas para ser inyectadas con @Inyect constructor(), entonces nos es necesario crear modulos que se puedan proveer
// y/o habilitar para ser inyectada  en otras clases y para ello usamos la etiqueta @Provides

@Module  //Con esta etiqueta le decimos a Dagger que esto es un modulo. Los modulos son los que proveen dependencias
@InstallIn(SingletonComponent::class)  // como parametros le ponemos el Alcance. cuando creamos un modulo, le podemos decir el alcance que queremos
// que tenga. por ejemplo si el alcance es a nivel de activity, cuando una activity necesite por ejemplo la dependencia de retrofit,
// dagger va a crear una instancia y se la va a dar a la activity, pero cuando esa activity muere, tambien muere esa instancia de retrofit,
// Si llamamos a retrofit por ejemplo 3 veces en una misma activity, se van a crear 3 isntancias de retrofit, y cuando esa activity muere,
// las 3 instancias que se crearon tambien mueren. Los alcances mas comunes son los de la Activity, el de el View Model y el de nivel de
//Aplicación que se usa cuando son cosas tan generales que sea necesario llamarla en todas partes del proyecto. Para este ejemplo,
// le ponemos que el alcance es de aplicación, ya que retrofit deberia poderse llamar de cualquier parte de la aplicación y para ello
// lo configuramos con "SingletonComponent::class" teniendo en cuenta que la palabra Singleton es solo un nombre, y no tiene nada que ver
// con el patron de diseño Singleton

object NetworkModuleProvider { // Los objetos pueden ser accedidos de manera directa, como si fueran variables o funciones dentro de un
    //companion Object y/o como funciones static en Java; es decir no se nececitan instanciar

    @Singleton // Usamos el patron de diseño Singleton para mantener una unica instancia de retrofit, de tal manera que no se creen varias cada vez que
    // llamemos a retrofit y con esto evitar consumir recursos de memoria sin tener la necesitad.
    @Provides // Con esta etiqueta habilitamos este modulo para que => si cualquiera de nuestras clases necesita una instancia de retrofit, Dagger Hilt
    // va a saber como darsela, es decir se va a poder inyectarsela en la clase que necesite esta dependencia.
    fun provideTiposIdentifRetrofit(): Retrofit { // retorna un objeto de tipo Retrofit. Como esta función esta configurada como @Provides, significa
        // que si en cualquier clase necesitamos una instacia de retrofit, simplemente la inyectamos, y Dagger Hilt va a buscar y a encontrar
        //esta a esta funcion, que retorna un objeto de Retrofit y la va a proveer.

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)  // configuramos
        // que tipo de traking vamos a hacer en la petición correpondiente, para este caso, estamos interceptando
        // las peticiones http y las mostramos a traves del logcat
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.bancoink.biz/qa/signup/")
            .addConverterFactory(GsonConverterFactory.create()) //usamos la libreria gson.converter para convertir un JSON
            .client(client)
            .build() // Construccion

        // Con val retrofit = Retrofit.Builder().....  ===> Creamos una instancia de un objeto de tipo Retrofit y tambien definimos la configuración inicial
        // de ese objeto retrofit, es decir se le configura la URL fuente de la API, el conversor de JSON obtenido a nuestro modelo de datos
        // que seria la clase ItemTipoIdentifFromApi etc

        return retrofit

        // OJO... debemos tener en cuenta que estas peticiones normalmente demoran un tiempo en responder, por tanto es importante que estas peticiones
        // se realicen de manera Asingrona (diferentes hilos), ya que no podemos esperar por esa respuesta, asi que mintras que la recibimos respuesta
        // de la API, se debe poder seguir usando y/o ejecutando nuestra applicacion. Lo anterior es importante, ya que en caso de no tener internet
        // la aplicación se puede bloquear totalmente.

        //Para que nuestra aplicación no se bloquee, no debemos trabajar de manera sincrona, es decir en el hilo principal.
        // Hilo => es cada uno de los procesos que realiza nuestra aplicación. Toda la parte visual de una aplicación va en el hilo principal, asi que cualquier
        // cosa que sea logica, perticiones HTTP, se deben hacer en hilos distintos para no bloquear el hilo principal y es aqui donde necesitamos usar las
        // corutinas que nos ayudan a hacer peticiones asincronas y lo hacemos con  CoroutineScope(Dispatchers.IO).launch { "xxxxxx" } ó con
        // viewModelScope.launch { } si estamos en un view Model
    }

    @Singleton // Usamos el patron de diseño Singleton para mantener una unica instancia de la interfaz ItemTipoIdentifApiClientInterface, de tal manera que
    // no se creen varias instancias cada vez que llamemos a la interfaz ItemTipoIdentifApiClientInterface y con esto evitar consumir recursos de memoria sin tener la necesitad.
    @Provides // Con esta etiqueta habilitamos este modulo para que => si cualquiera de nuestras clases necesita una instancia de la interfaz ItemTipoIdentifApiClientInterface,
    // Dagger Hilt va a saber como darsela, es decir se va a poder inyectarsela en la clase que necesite esta dependencia.
    fun provideItemTipoIdentifApiClient(retrofit: Retrofit): ItemTipoIdentifApiClientInterface { // Esta funcion retorna un objeto de tipo ItemTipoIdentifApiClientInterface.
        // Como esta función esta configurada como @Provides, significa que si en cualquier clase necesitamos una instacia de interfaz ItemTipoIdentifApiClientInterface,
        // simplemente la inyectamos, y Dagger Hilt va a buscar y a encontrar a esta funcion, que retorna un objeto de ItemTipoIdentifApiClientInterface y la va a proveer.

        // (retrofit: Retrofit) es proveido por la función provideTiposIdentifRetrofit existente en este mismo modulo. Esto Funciona
        // debido a que la función provideTiposIdentifRetrofit es una función @Provides y esa nos provee retrofit para inyectarla en cualquier
        // clase que la requiera y tambien se puede proveer en otras funciones @Provides como sucede en este caso

        return retrofit.create(ItemTipoIdentifApiClientInterface::class.java) // Se retorna un objeto de tipo ItemTipoIdentifApiClientInterface.
        // el cual es un retrofit mesclado con la interfaz,es decir ya va el retrofit completo.
    }
/*
    @Singleton
    @Provides
    fun provideTiposGeneroRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.bancoink.biz/qa/signup/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }
*/
    @Singleton
    @Provides
    fun provideItemTipoGeneroApiClient(retrofit: Retrofit): ItemTipoGeneroApiClientInterface {

        return retrofit.create(ItemTipoGeneroApiClientInterface::class.java) // Se retorna un objeto de tipo ItemTipoGeneroApiClientInterface.
        // el cual es un retrofit mesclado con la interfaz,es decir ya va el retrofit completo.
    }
}