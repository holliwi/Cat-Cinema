package com.example.ilovexxx.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ilovexxx.R
import com.example.ilovexxx.data.ApiService
import com.example.ilovexxx.model.CinemaData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // новый поток, чтобы запрос происходил в фоне
        // всё, что не делается снизу - делается в UI потоке
        CoroutineScope(Dispatchers.IO).launch {
            getFilmsList()
        }
    }

    // взять список фильмов из запроса
    suspend fun getFilmsList() {
        try {//создаем наш файл (в кото^ром запрос)
            val retrofit = Retrofit.Builder()
                .baseUrl("https://kinopoiskapiunofficial.tech/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

            // выполняем запрос
            val response = retrofit.getFilms()

            if (response.isSuccessful) { // если всё прошло успешно, мы получили данные

                val result: CinemaData = response.body()!!
                Log.i("bazooka", "getFilmsList: $result")

                withContext(Dispatchers.Main) {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    intent.putExtra("cinemaxxx", result.films)
                    startActivity(intent)
                }

            } else { // если ошибка в запросе и данных нам не дали =(
                Log.i("bazooka", "error sosi =((((")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("bazooka", "getFilmsList: $e")
        }
    }
}