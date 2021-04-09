package com.example.tasks.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import com.example.tasks.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.Executor

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Inicializa eventos
        setListeners()
        observe()

        mViewModel.isAuthenticationAvailable()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            handleLogin()
        } else if (v.id == R.id.text_register) {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun showAuthentication() {
        val executor: Executor = ContextCompat.getMainExecutor(this)

        val biometricPrompt =
            BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)

                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            })

        val info: BiometricPrompt.PromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Titulo")
            .setSubtitle("Subtitulo")
            .setDescription("Descrição")
            .setNegativeButtonText("Cancelar")
            .build()

        biometricPrompt.authenticate(info)
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        button_login.setOnClickListener(this)
        text_register.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {
        mViewModel.login.observe(this, {
            if (it.success()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it.falure(), Toast.LENGTH_SHORT).show()
            }
        })

        mViewModel.fingerPrint.observe(this, {
            if (it) {
                showAuthentication()
            }
        })
    }

    /**
     * Autentica usuário
     */
    private fun handleLogin() {
        val email = edit_email.text.toString()
        val password = edit_password.text.toString()

        mViewModel.doLogin(email, password)
    }

}
