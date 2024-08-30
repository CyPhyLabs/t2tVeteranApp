package com.example.veterant2t.ApiSetup
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.UUID

object ApiClient {

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Build an OkHttpClient with the interceptor
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val baseURL: String = "http://10.0.2.2:8000/"
    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val authService= retrofit.create(AuthService::class.java)

    public fun onLoginSuccess(){

    }
}

interface AuthService{
    @POST("api/login/")
    fun login(@Body request: loginRequest): Call<loginResponse>

    @POST("api/register/")
    fun register(@Body request: registerRequest): Call<registerResponse>

    @POST("api/device-token/")
    fun registerDeviceToken(@Body request: tokenRegistrationRequest): Call<tokenRegistrationResponse>
}






data class loginRequest(
    val username: String,
    val password: String,
    val email: String

)

data class loginResponse(val access: String, val refresh: String)

data class registerRequest(val username: String, val email: String, val password: String)
data class registerResponse(val username: String, val email: String, val password: String, val userType:String="user")
data class tokenRegistrationRequest(val token: String)
data class tokenRegistrationResponse(val id:UUID, val user_id:UUID, val token: String, val created_at:String, val updated_at:String)