package ApiSetup
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
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
    val authService=retrofit.create(AuthService::class.java)
}

interface AuthService{
    @POST("api/login/")
    fun login(@Body request: loginRequest): Call<loginResponse>

    @POST("api/register/")
    fun register(@Body request: registerRequest): Call<registerResponse>
}





data class loginRequest(
    val username: String,
    val password: String,
    val email: String

)

data class loginResponse(val access: String, val refresh: String)

data class registerRequest(
    val username: String,
    val email: String,
    val password: String

)

data class registerResponse(val username: String, val email: String, val password: String, val userType:String="user")
