package br.edu.puc.uteethdentista

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.edu.puc.uteethdentista.databinding.FragmentCurriculoBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase

class CurriculoFragment : AppCompatActivity() {

    private lateinit var binding: FragmentCurriculoBinding
    //private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCurriculoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.imgbArrow.setOnClickListener {
            val intent = Intent(this, CriarContaFragment::class.java)
            startActivity(intent)
            finish()

        }
    }
}

