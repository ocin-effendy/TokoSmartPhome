package com.example.tokosmartphome

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivShop = findViewById<ImageView>(R.id.iv_shop)
        val nameSplashScreen = findViewById<TextView>(R.id.name_splash_screen)

        ivShop.alpha = 0f
        nameSplashScreen.alpha = 0f
        nameSplashScreen.animate().setDuration(1500).alpha(1f)

        ivShop.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}