package pe.edu.upc.nasaproject.viewcontrollers.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.activity_photos.*
import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.models.Photo
import pe.edu.upc.nasaproject.network.NasaApi
import pe.edu.upc.nasaproject.network.PhotosResponse
import pe.edu.upc.nasaproject.viewcontrollers.adapters.PhotosAdapter

class PhotosActivity : AppCompatActivity() {
    var photos = ArrayList<Photo>()
    lateinit var photosRecyclerView: RecyclerView
    lateinit var photosAdapter: PhotosAdapter
    lateinit var photosLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        photosRecyclerView = pictureRecycler
        photosAdapter = PhotosAdapter(photos, this)
        photosLayoutManager = GridLayoutManager(this, 1) as RecyclerView.LayoutManager
        photosRecyclerView.adapter = photosAdapter
        photosRecyclerView.layoutManager = photosLayoutManager

        NasaApi.requestPhotos(getString(R.string.nasa_api_key),
                { response -> handleResponse(response)},
                { error -> handleError(error)})
    }
    private fun handleResponse(response: PhotosResponse?) {
        if (false) {
            Log.d("CatchUp", "No se logro")
            return
        }

        photos = response!!.photos!!
        Log.d("CatchUp", "Found ${photos.size} photos")
        photosAdapter.photos = photos
        photosAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d("CatchUp", anError!!.message)
    }
}
