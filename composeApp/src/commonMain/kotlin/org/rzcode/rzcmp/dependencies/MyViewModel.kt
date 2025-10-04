package org.rzcode.rzcmp.dependencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel(
    private val myRepository: MyRepository,
) : ViewModel() {

    private val _samplePostTitle = MutableStateFlow("Loading sample post…")
    val samplePostTitle: StateFlow<String> = _samplePostTitle.asStateFlow()

    init {
        viewModelScope.launch {
            runCatching { myRepository.fetchSamplePostTitle() }
                .onSuccess { title -> _samplePostTitle.value = title }
                .onFailure { throwable ->
                    _samplePostTitle.value = "Failed to load post: ${throwable.message ?: "unknown error"}"
                }
        }
    }

    fun getHelloWorld(): String {
        return myRepository.getHelloWorld()
    }
}
