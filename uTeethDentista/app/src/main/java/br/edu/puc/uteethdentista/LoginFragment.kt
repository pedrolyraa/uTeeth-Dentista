package br.edu.puc.uteethdentista

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.edu.puc.uteethdentista.databinding.FragmentLoginBinding

class LoginFragment : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()
        window.statusBarColor= Color.parseColor("#FFFFFFFF")

        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this,CriarContaFragment::class.java)
            startActivity(intent)
            finish()
        }


    }





}