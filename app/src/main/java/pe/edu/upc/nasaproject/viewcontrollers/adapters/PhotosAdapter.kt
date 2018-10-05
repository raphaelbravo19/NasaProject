package pe.edu.upc.nasaproject.viewcontrollers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.photo.view.*
import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.models.Photo

class PhotosAdapter(var photos: ArrayList<Photo>, val context: Context) :
        RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.photo, parent, false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos.get(position)
        holder.updateFrom(photo)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pictureRover = view.pictureRover

        fun updateFrom(photo: Photo) {
            pictureRover.setDefaultImageResId(R.mipmap.ic_launcher)
            pictureRover.setErrorImageResId(R.mipmap.ic_launcher)
            pictureRover.setImageUrl(photo.img_src)
        }
    }
}