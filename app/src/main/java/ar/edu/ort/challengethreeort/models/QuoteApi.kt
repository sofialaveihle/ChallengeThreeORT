package ar.edu.ort.challengethreeort.models

import com.google.gson.annotations.SerializedName

data class QuoteApi(
    @SerializedName(value="quote") val quote: String,
    @SerializedName(value="author") val author: String,
    @SerializedName(value="category") val category: String
)
