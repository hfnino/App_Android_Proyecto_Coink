package co.com.personal.hnino.coink.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartAppViewModel @Inject constructor(): ViewModel()  {

    var isLoading = MutableLiveData<Boolean>()

    fun sleepPantallaInicio(){

        isLoading.postValue(true)
        Thread.sleep(4000)
        isLoading.postValue(false)
    }
}