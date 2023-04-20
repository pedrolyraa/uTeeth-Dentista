package br.edu.puc.uteethdentista

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.hide()
        window.statusBarColor= Color.parseColor("#040957")


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,LoginFragment::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}