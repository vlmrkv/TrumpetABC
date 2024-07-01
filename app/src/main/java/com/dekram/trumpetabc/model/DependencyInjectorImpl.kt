package com.dekram.trumpetabc.model

class DependencyInjectorImpl : DependencyInjector {

    override fun modelRepository(): ModelRepository {
        return ModelRepositoryImpl()
    }
}