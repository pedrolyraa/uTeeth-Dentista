package br.edu.puc.uteethdentista

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.edu.puc.uteethdentista.databinding.FragmentCriarContaBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase

class CriarContaFragment : AppCompatActivity() {

    private lateinit var binding: FragmentCriarContaBinding
    private val auth = FirebaseAuth.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCriarContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor= Color.parseColor("#FFFFFFFF")

        binding.btnNext.setOnClickListener {
            val intent = Intent(this,CurriculoFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.imgbArrow.setOnClickListener {
            val intent = Intent(this,LoginFragment::class.java)
            startActivity(intent)
            finish()
        }

    }
}
