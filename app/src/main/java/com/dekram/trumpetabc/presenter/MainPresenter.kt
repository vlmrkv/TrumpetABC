package com.dekram.trumpetabc.presenter

import com.dekram.trumpetabc.MainContract
import com.dekram.trumpetabc.model.DependencyInjector

class MainPresenter(view: MainContract.View, dependencyInjector: DependencyInjector) :
    MainContract.Presenter {

    private val modelRepository = dependencyInjector.modelRepository()
    private var view: MainContract.View? = view

    override fun onViewCreated() {
        view?.showMainActivity()
    }

    override fun onFingeringsButtonClicked() {
        view?.showFingeringsScreen()
    }

    override fun onTonesButtonClicked() {
        view?.showTonesScreen()
    }

    override fun onNotesCardsButtonClicked() {
        view?.showNotesCardsScreen()
    }

    override fun onDestroy() {
        this.view = null
    }
}