package org.rzcode.rzcmp.dependencies

interface MyRepository {
    fun getHelloWorld(): String
}

class MyRepositoryImpl(
    private val dataBase: MyDataBase
): MyRepository{
    override fun getHelloWorld(): String {
        return "Hello world from repository!"
    }
}