package pe.edu.upc.nasaproject.viewcontrollers.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.activity_start.*
import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.models.DayImage
import pe.edu.upc.nasaproject.network.DayImageResponse
import pe.edu.upc.nasaproject.network.NasaApi

class StartActivity : AppCompatActivity() {
    lateinit var imageDay: DayImageResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        NasaApi.requestImageOfTheDay(getString(R.string.nasa_api_key),
                { response -> handleResponse(response)},
                { error -> handleError(error)})
        imageOfDay.setOnClickListener {
            startActivity(Intent(this, PhotosActivity::class.java))
        }
        textExplain.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
    private fun handleResponse(response: DayImageResponse?) {
        if ("".equals(response!!.title, true)) {
            Log.d("NasaApp", "No se encontro imagen")
            return
        }
        imageDay = response
        imageOfDay.setImageUrl(imageDay.url)
        textTitle.text=imageDay.title
        textExplain.text=imageDay.explanation
    }

    private fun handleError(anError: ANError?) {
        Log.d("NasaApp", anError!!.message)
        textTitle.text="No se puede mostrar informacion"
        textExplain.text="No se puede mostrar informacion"
    }
}
