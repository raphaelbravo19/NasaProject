package pe.edu.upc.nasaproject.models

class Sesion {
    companion object {
        var username: String = ""
        var password: String = ""

        fun returnsession(): Boolean{
            return !(username.equals("") || password.equals(""))
        }
    }
}