package pe.edu.upc.nasaproject.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class NasaApi{
    companion object {
        val baseUrl = "https://api.nasa.gov"
        val imageOfTheDay = "$baseUrl/planetary/apod"
        val photosRover = "$baseUrl/mars-photos/api/v1/rovers/curiosity/photos"

        fun requestImageOfTheDay(key: String,
                             responseHandler: (DayImageResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(NasaApi.imageOfTheDay)
                    .addQueryParameter("api_key", key)
                    .setPriority(Priority.LOW)
                    .setTag("NasaProject")
                    .build()
                    .getAsObject(DayImageResponse::class.java,
                            object : ParsedRequestListener<DayImageResponse> {
                                override fun onResponse(response: DayImageResponse?) {
                                    responseHandler(response)
                                }
                                override fun onError(anError: ANError?) {
                                    errorHandler(anError)
                                }
                            })
        }
        fun requestPhotos(key: String,
                          responseHandler: (PhotosResponse?) -> Unit,
                          errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(NasaApi.photosRover)
                    .addQueryParameter("api_key", key)
                    .addQueryParameter("sol", "1000")
                    .setPriority(Priority.LOW)
                    .setTag("NasaProject")
                    .build()
                    .getAsObject(PhotosResponse::class.java,
                            object : ParsedRequestListener<PhotosResponse> {
                                override fun onResponse(response: PhotosResponse?) {
                                    responseHandler(response)
                                }
                                override fun onError(anError: ANError?) {
                                    errorHandler(anError)
                                }
                            })
        }
    }
}