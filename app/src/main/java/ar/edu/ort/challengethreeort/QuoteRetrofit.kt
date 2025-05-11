package ar.edu.ort.challengethreeort

import ar.edu.ort.challengethreeort.models.Quote
import javax.inject.Inject

data class QuoteRetrofit
@Inject
constructor(private val service: QuotesApi) : IServiceQuotes {
//Inyección de dependencia Retrofit y devolverá una interfaz

    override suspend fun getQuotes(): List<Quote>? {

        val response = service.getQuotes()

        return if (response.isSuccessful) {
            val result = response.body()?.map {
                Quote(
                    quote = it.quote,
                    author = it.author,
                    category = it.category
                )
            }
            result
        } else {
            emptyList()
        }
    }
}
