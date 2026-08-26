package com.dekram.trumpetabc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dekram.trumpetabc.databinding.ActivityMainBinding
import com.dekram.trumpetabc.model.DependencyInjectorImpl
import com.dekram.trumpetabc.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    lateinit var mainPresenter: MainContract.Presenter
        private set
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dependencyInjector = DependencyInjectorImpl()
        mainPresenter = MainPresenter(this, dependencyInjector)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            ?: throw IllegalStateException("NavHostFragment not found. Check activity_main.xml for id nav_host_fragment")
        navController = navHostFragment.navController

        setPresenter(mainPresenter)

        mainPresenter.onViewCreated()
    }



    override fun setPresenter(presenter: MainContract.Presenter) {
        mainPresenter = presenter
    }

    override fun showMainActivity() {

    }

    override fun showFingeringsScreen() {
        navController.navigate(R.id.action_home_fragment_to_tunerFragment)
    }

    override fun showTonesScreen() {
        navController.navigate(R.id.action_home_fragment_to_tonesFragment)
    }

    override fun showNotesCardsScreen() {
        navController.navigate(R.id.action_home_fragment_to_notesCardFragment)
    }

    override fun onDestroy() {
        if (::mainPresenter.isInitialized) {
            mainPresenter.onDestroy()
        }
        super.onDestroy()
    }
}