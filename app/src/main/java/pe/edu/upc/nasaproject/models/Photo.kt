package pe.edu.upc.nasaproject.models

data class Photo(
        val id: Int,
        val sol: Int,
        val camera: Camera? = null,
        val img_src: String,
        val earth_date: String? = "",
        val rover: Rover? = null
)