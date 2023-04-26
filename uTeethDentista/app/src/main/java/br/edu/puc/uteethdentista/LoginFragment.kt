package br.edu.puc.uteethdentista

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.edu.puc.uteethdentista.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private val auth = FirebaseAuth.getInstance()






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this,CriarContaFragment::class.java)
            startActivity(intent)
            finish()
        }

        supportActionBar?.hide()
        window.statusBarColor= Color.parseColor("#FFFFFFFF")

        binding.btnSignIn.setOnClickListener{view ->
            val email = binding.etEmailLogin.text.toString()
            val senha = binding.etPasswordLogin.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener{autenticacao ->
                    if (autenticacao.isSuccessful){
                        navegarHome()
                    }

                }

            }
        }

        }
        private fun navegarHome(){
        val intent = Intent(this,HomeFragment::class.java)
        startActivity(intent)
        finish()





    }





}