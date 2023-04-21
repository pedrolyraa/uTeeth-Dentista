package br.edu.puc.uteethdentista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.edu.puc.uteethdentista.databinding.FragmentCriarContaBinding

class CriarContaFragment : AppCompatActivity() {

    private lateinit var binding: FragmentCriarContaBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCriarContaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCriar.setOnClickListener{
            val navegarCadastrar = Intent(this, LoginFragment::class.java)
            startActivity(navegarCadastrar)
        }
    }
}
