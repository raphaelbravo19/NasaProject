package pe.edu.upc.nasaproject

import com.androidnetworking.AndroidNetworking
import com.orm.SugarApp

class NasaProjectApp : SugarApp() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext())
    }
}