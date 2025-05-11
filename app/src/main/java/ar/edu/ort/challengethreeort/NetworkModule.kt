package ar.edu.ort.challengethreeort

import ar.edu.ort.challengethreeort.core.Config
import ar.edu.ort.challengethreeort.core.MyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor).addInterceptor(MyInterceptor)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        //Creo Retrofit
        return Retrofit.Builder()
            //Defino Url base
            .baseUrl(Config.baseUrl)
            .client(client)
            //Defino canal de comunicación (Gson)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    //Se crea QuotesApi y ya existe en todo el proyecto
    fun provideQuoteApiClient(retrofit: Retrofit): QuotesApi {
        return retrofit.create(QuotesApi::class.java)
    }
}