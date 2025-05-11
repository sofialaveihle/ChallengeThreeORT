package ar.edu.ort.challengethreeort.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.challengethreeort.GetServiceQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //Inject: que a mi ViewModel, Hilt va a inyectar un objeto GetServiceQuotes, capa de servicios
    //
    private val getQuotesUseCase: GetServiceQuotes
) : ViewModel() {

    //Definimos atributos que manejan la mutabilidad del estado
    var Quote = mutableStateOf(value = "Cargando...")
    var Author = mutableStateOf(value = "")
    var Category = mutableStateOf(value = "")

    //Función llamada en MainActivity
    fun loadQuotes() {

        /*ViewModelScope: espacio de corrutinas.
        Función que convierte todo lo que contiene dentro, en asincrónico.
        Las corrutinas son ejecuciones en segundo plano que no se ejecutan con el main thread

        Suspended functions: la única forma de ejecutarlas, es fuera del scope principal porque
        si se deja en el thread principal se corre el riesgo de que la API tarde en responder,
        se cuelgue la app y Android la cierre.
        */
        viewModelScope.launch {
            val quote = getQuotesUseCase.invoke() //Devuelve lista de frases
            if (!quote.isNullOrEmpty() && quote.size > 0) {
                Quote.value = quote!!.get(0)!!.quote
                Author.value = quote!!.get(0)!!.author
                Category.value = quote!!.get(0)!!.category
            }
        }
    }
}