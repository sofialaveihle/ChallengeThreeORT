package ar.edu.ort.challengethreeort

import android.app.Application
import ar.edu.ort.challengethreeort.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Cuando se crea la app, se crea el objeto Config
        Config.apiKey = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.quotes_api_base_url)

    }
}