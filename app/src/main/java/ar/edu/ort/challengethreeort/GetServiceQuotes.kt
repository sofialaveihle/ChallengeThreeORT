package ar.edu.ort.challengethreeort

import ar.edu.ort.challengethreeort.models.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetServiceQuotes @Inject constructor(
    private val quoteRetrofit: QuoteRetrofit
) {
    //De nuevo, función asincrónica, que devuelve una lista de frases
    suspend fun invoke(): List<Quote>? = withContext(context = Dispatchers.IO) {
        quoteRetrofit.getQuotes() //Llama internamente quoteRetrofit (que le llegó por inyección de dep.)
    }
}