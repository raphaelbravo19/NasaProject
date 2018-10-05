package pe.edu.upc.nasaproject.viewcontrollers.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.models.Sesion
import pe.edu.upc.nasaproject.models.User
import pe.edu.upc.nasaproject.viewcontrollers.activities.CheckActivity


class RegisterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        view.buttonRegistrar.setOnClickListener { view ->
            var user = editUsuario.text.toString()
            var pass = editContraseña.text.toString()
            if (!(user.equals("") || pass.equals(""))){
                var temp = User.findUser(user,pass)
                if (!temp){
                    User.registerUser(user,pass)
                    Log.d("NasaLogin","Se ingreso $user")
                }
                /*val context = view.context
                context.startActivity(Intent(context, CheckActivity::class.java))*/

            }

        }
        return view
    }
}
