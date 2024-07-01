package com.dekram.trumpetabc.presenter

import com.dekram.trumpetabc.MainContract
import com.dekram.trumpetabc.model.DependencyInjector

class MainPresenter(view: MainContract.View, dependencyInjector: DependencyInjector) :
    MainContract.Presenter {

    private val modelRepository = dependencyInjector.modelRepository()
    private var view: MainContract.View? = view

    private fun loadMainActivity() {
        //view?.showMainActivity()
    }

    fun loadFingerings() {
        //view?.showFingeringsScreen()
    }

    override fun onDestroy() {
        //this.view = null
    }

    override fun onViewCreated() {
        loadMainActivity()
    }

    override fun onFingeringsButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun onTonesButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun onNotesCardsButtonClicked() {
        TODO("Not yet implemented")
    }
}