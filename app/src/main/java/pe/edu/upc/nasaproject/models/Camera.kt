package pe.edu.upc.nasaproject.models

data class Camera(
        val id: Int,
        val name: String? = "",
        val rover_id: Int,
        val full_name: String? = ""
)