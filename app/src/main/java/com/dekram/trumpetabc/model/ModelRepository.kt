package com.dekram.trumpetabc.model

interface ModelRepository {

    fun loadFingerings()

    fun loadTones()

    fun loadNotesCards()
}