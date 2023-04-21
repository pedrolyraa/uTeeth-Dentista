package br.edu.puc.uteethdentista

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.puc.uteethdentista.databinding.FragmentLoginBinding

class LoginFragment : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCriarconta.setOnClickListener{
            val navegarCriarConta = Intent(this, CriarContaFragment::class.java)
        }

        binding.btnEntrar.setOnClickListener{
            val navegarHome = Intent(this, HomeFragment::class.java)
            startActivity(navegarHome)
        }
    }
}