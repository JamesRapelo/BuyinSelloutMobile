package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2

import android.content.Intent
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.ActivitySignupBinding
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import java.io.StringReader

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            val name = binding.fullname.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            val signupDataJson = "{\"name\":\"$name\",\"email\":\"$email\",\"password\":\"$password\"}"

            if (name.isEmpty()) {
                binding.fullname.error = "Full Name Required"
                binding.fullname.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                binding.email.error = "Email Required"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.password.error = "Password Required"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            try {
                val reader = JsonReader(StringReader(signupDataJson))
                reader.isLenient = true
                reader.beginObject()
                reader.close()

                RetrofitClient.instance.createUser(name, email, password)
                    .enqueue(object :
                    Callback<DefaultResponse> {
                    override fun onResponse(
                        call: Call<DefaultResponse>,
                        response: retrofit2.Response<DefaultResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            Toast.makeText(applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                            finish()
                        } else {
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

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
