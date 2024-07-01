package com.dekram.trumpetabc

interface MainContract {

    interface Presenter: BasePresenter {
        fun onViewCreated()

        fun onFingeringsButtonClicked()

        fun onTonesButtonClicked()

        fun onNotesCardsButtonClicked()
    }

    interface View: BaseView<Presenter> {
        fun showMainActivity()

        fun showFingeringsScreen()

        fun showTonesScreen()

        fun showNotesCardsScreen()
    }
}