package co.com.personal.hnino.coink

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Esta etiqueta por detras, nos genera el codigo necesario para usar Dagger Hilt para
    // inyección de dependencias. La idea de implementar Inyección de dependencias es que dentro de una clase,
    // no se tenga ninguna instacia de ninguna clase, ya que todas deberian ser inyectadas, La inyeción de
    //dependencias es un conjunto de tecnicas para reducir el acomplamiento de las clases.

open class ProyectoCoinkApp: Application(){ // Esta clase extiende de Application(), lo que significa que
    // contamos con el contexto general de la aplicacion si la necesitaramos. Una clase de tipo Application
    // es una que extiende de la propia aplicacion deAndroid, por lo que  normalmente son las primeras en
    // llamarsen cuando se inicia la aplicación, y para ques sea así, configuramos esta clase en AndoridManifest.xml
    // en la linea android:name=".ProtectoCoinkApp" lo que significa que tan pronto se inicie la aplicacion
    // tambien inicia la clase ProtectoCoinkApp, y habilitará las funcionalidades de Dagger Hilt para
    // inyección de dependencias.
}