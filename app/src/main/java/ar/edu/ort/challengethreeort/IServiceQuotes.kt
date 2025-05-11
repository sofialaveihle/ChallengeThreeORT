package ar.edu.ort.challengethreeort

import ar.edu.ort.challengethreeort.models.Quote

interface IServiceQuotes {

    suspend fun getQuotes(): List<Quote>?

}