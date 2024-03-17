package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.ActivityLoginBinding
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("myPreference", Context.MODE_PRIVATE)
        binding.loginButton.setOnClickListener {
            val email = binding.logemail.text.toString()
            val password = binding.logpassword.text.toString()

            val signinDataJson =
                "{\"email\":\"$email\",\"password\":\"$password\"}"

            if (email.isEmpty()) {
                binding.logemail.error = "Email required"
                binding.logemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.logpassword.error = "Password required"
                binding.logpassword.requestFocus()
                return@setOnClickListener
            }

            try {
                val reader = JsonReader(StringReader(signinDataJson))
                reader.isLenient = true
                reader.beginObject()
                reader.close()

                RetrofitClient.instance.login(email, password).enqueue(object :
                    Callback<DefaultResponse> {
                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: Response<DefaultResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            // Handle successful response
                            Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                        } else {
                            // Handle unsuccessful response
                            val errorMessage: String = try {
                                response.errorBody()?.string()
                                    ?: "Failed to get a valid response. Response code: ${response.code()}"
                            } catch (e: Exception) {
                                "Failed to get a valid response. Response code: ${response.code()}"
                            }
                            Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
                            Log.e("API_RESPONSE", errorMessage)
                        }
                    }
                })
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Error parsing JSON", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }

        binding.signup.setOnClickListener {
            startActivity(Intent(applicationContext, SignupActivity::class.java))
            finish()
        }

        binding.home.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    private fun saveTokenToSharedPreferences(token: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("authToken", token)
        editor.apply()
    }
}
