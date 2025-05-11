package ar.edu.ort.challengethreeort

import ar.edu.ort.challengethreeort.models.QuoteApi
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET(value = "/v1/quotes")
    suspend fun getQuotes(): Response<List<QuoteApi>>
}