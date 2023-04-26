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


        binding.btnCriar.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val senha = binding.etSenha.text.toString()
            val confirmarSenha = binding.etConfirmarSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()){
                val snackbar = Snackbar.make(it, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener{ cadastro ->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(it, "Você foi cadastrado!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.show()
                        binding.etEmail.setText("")
                        binding.etSenha.setText("")
                        binding.etConfirmarSenha.setText("")
                    }
                }.addOnFailureListener{ exception ->
                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                        is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada!"
                        is FirebaseNetworkException -> "Sem conexão com a internet!"
                        else -> "Erro ao cadastrar usuário!"
                    }
                    val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()

                }
                val navegarCadastrar = Intent(this, LoginFragment::class.java)
                startActivity(navegarCadastrar)
            }

        }
    }
}
