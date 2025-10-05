package org.rzcode.rzcmp.dependencies

import kotlinx.serialization.Serializable

@Serializable
data class SamplePost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)
