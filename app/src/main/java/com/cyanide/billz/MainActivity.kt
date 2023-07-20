package com.cyanide.billz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cyanide.billz.databinding.ActivityMainBinding




class RrachMainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
    }

    fun validateSignup(){
        val userName= binding.etUserName.text.toString()
        val email= binding.etEmail.text.toString()
        val password= binding.etPassword.text.toString()
        val confirmPassword= binding.etConfirmPassword.text.toString()
        var error=false

        if (userName.isBlank()){
            binding.tilUserName.error="First name is required."
            error=true
        }

        if (email.isBlank()){
            binding.tilEmail.error="Email is required."
            error=true
        }
        if (password.isBlank()){
            binding.tilPassword.error="Password is required."
            error=true
        }
        if (userName.isBlank()){
            binding.tilConfirmPassword.error="Password confirmation is required."
            error=true
        }
        if (password!=confirmPassword){
            binding.tilConfirmPassword.error="Passwords don't match."
            error=true
        }
        if (!error){
            Toast
                .makeText(this, "$userName   $email",Toast.LENGTH_LONG)
                .show()
        }

    }
}