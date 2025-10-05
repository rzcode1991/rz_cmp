package org.rzcode.rzcmp.dependencies

interface MyRepository {
    fun getHelloWorld(): String
    suspend fun fetchSamplePostTitle(): String
}

class MyRepositoryImpl(
    private val dataBase: MyDataBase,
    private val sampleApi: SampleApi,
) : MyRepository {
    override fun getHelloWorld(): String {
        return "Hello world from repository!"
    }

    override suspend fun fetchSamplePostTitle(): String {
        return sampleApi.getSamplePost(1).title
    }
}
