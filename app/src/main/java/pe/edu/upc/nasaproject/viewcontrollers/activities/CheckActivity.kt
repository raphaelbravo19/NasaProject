package pe.edu.upc.nasaproject.viewcontrollers.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.models.Sesion

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Sesion.returnsession()) {
            setContentView(R.layout.user_correct)
        }else{
            setContentView(R.layout.user_incorrect)
        }

    }
}
