package pe.edu.upc.nasaproject.models

import com.orm.SugarRecord

public class User : SugarRecord() {
    var usuario: String = ""
    var contrasena: String = ""
    companion object {
        fun findUser(username: String, password: String): Boolean {
            val user = SugarRecord.find(
                    User::class.java,
                    "usuario = ? AND contrasena = ?", username, password)
            return user.size > 0
        }
        fun registerUser(username: String, password: String) {
            val user = User()
            user.usuario = username
            user.contrasena = password
            user.save()
        }
    }
}