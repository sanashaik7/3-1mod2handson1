package com.example.a3_1mod2handson1.network

import com.example.a3_1mod2handson1.model.ChatRequest
import com.example.a3_1mod2handson1.model.ChatResponse
import com.example.a3_1mod2handson1.utils.Constants.END_POINT
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(END_POINT)
    suspend fun getAIResponse(
        @Body request: ChatRequest
    ): ChatResponse
}
