package com.example.nawkhabar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.nawkhabar.databinding.ActivitySplashScreenBinding
const val SPLASH_TIME : Long = 4000
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)

        val anim = AnimationUtils.loadAnimation(this,R.anim.fade_in_anim)

        binding.name.animation = anim
        binding.title.animation = anim
        binding.imageView.animation = anim
    }
}