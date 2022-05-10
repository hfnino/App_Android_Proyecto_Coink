package co.com.personal.hnino.coink.data.model

import co.com.personal.hnino.coink.data.model.entidades.UserDataApp
import javax.inject.Inject
import javax.inject.Singleton



class UserDataAppProvider {

    companion object{

        var userDataApp = UserDataApp() // No requiere que le demos parametros, ya que todos los atributos de
        //la clase UserDataApp tienen asignado valores por defecto.
    }
}