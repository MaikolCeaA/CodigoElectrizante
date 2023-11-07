package com.example.codigoelectrizante.vistas


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.codigoelectrizante.R

class IngresarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ingresar, container, false)

        val usernameEditText: EditText = view.findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = view.findViewById(R.id.passwordEditText)
        val loginButton: Button = view.findViewById(R.id.loginButton)
        val loginStatusTextView: TextView = view.findViewById(R.id.loginStatusTextView)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "admin" && password == "123456") {
                loginStatusTextView.text = "Inicio de sesión exitoso"
            } else {
                loginStatusTextView.text = "Credenciales incorrectas. Inténtalo de nuevo."
            }
        }

        return view
    }
}