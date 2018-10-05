package pe.edu.upc.nasaproject.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*
import pe.edu.upc.nasaproject.R
import pe.edu.upc.nasaproject.viewcontrollers.fragments.LoginFragment
import pe.edu.upc.nasaproject.viewcontrollers.fragments.RegisterFragment

class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_register
    }

    private fun fragmentFor(item: MenuItem): Fragment {
        when(item.itemId) {
            R.id.navigation_register -> {
                return RegisterFragment()
            }
            R.id.navigation_login -> {
                return LoginFragment()
            }
        }
        return RegisterFragment()
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentFor(item))
                .commit() > 0
    }
}
