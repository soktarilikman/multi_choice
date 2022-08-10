package uz.gita.contactfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uz.gita.contactfragment.ui.screens.MainScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainFragment = MainScreen()
        openFragment(mainFragment)

    }


    fun openFragment(fm: Fragment) {
        if (!fragmentExist(fm))
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fm, fm.javaClass.name)
                .commit()
    }

    fun openFragmentWithBackStack(fm: Fragment) {
        if (!fragmentExist(fm))
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fm, fm.javaClass.name)
                .addToBackStack(fm.javaClass.name)
                .commit()
    }

    fun popUp() {
        supportFragmentManager.popBackStack()
    }

    private fun fragmentExist(fm: Fragment): Boolean {
        return supportFragmentManager.findFragmentByTag(fm.javaClass.name) != null
    }


}