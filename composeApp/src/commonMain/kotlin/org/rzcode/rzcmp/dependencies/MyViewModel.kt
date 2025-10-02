package org.rzcode.rzcmp.dependencies

import androidx.lifecycle.ViewModel

class MyViewModel(
    private val myRepository: MyRepository
): ViewModel() {

    fun getHelloWorld(): String{
        return myRepository.getHelloWorld()
    }

}