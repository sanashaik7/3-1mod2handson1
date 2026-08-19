package com.example.a3_1mod2handson1.model

data class ChatResponse(
    val candidates: List<Candidate>
) {
    val response: String
        get() = candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text ?: "No response received"
}

data class Candidate(
    val content: Content
)
