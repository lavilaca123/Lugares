package com.lugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lugares.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    // el binding  genera una clase de vinculación para cada archivo de diseño XML presente en ese módulo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp (this)
        auth = Firebase.auth

        binding.btLogin.setOnClickListener(
        ){
            haceLogin()

        }

        binding.btRegister.setOnClickListener(
        ){
            haceRegister()

        }

        binding.btnHola.setOnClickListener(){
            Toast.makeText(this,"Hola desde android studio", Toast.LENGTH_LONG).show()


        }

        binding.btnDespedida.setOnClickListener(){
            Toast.makeText(this,"Adios desde android studio", Toast.LENGTH_LONG).show()


        }

    }

    private fun haceRegister() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
               if(task.isSuccessful){
                   Log.d('Creando Usuario','Registrado')
                   val user = auth.currentUser
                   actualiza(user)
               } else {
                   Log.d('creando Usuario','Fallo')
                   Toast.makeText(this,"fallo",Toast.LENGTH_LONG).show()
                   actualiza(null)

               }


            }

    // cuando esto se complete agregue un evento y hagalo ahora de manera syncrona

    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null)
        {
            val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }
    }



        public override fun onStart (){
            super.onStart()
            val usuario= auth.currentUser
            actualiza(usuario)
        }

    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful){
                    Log.d('Autenticando','Autenticado')
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d('Autenticando','Fallo')
                    Toast.makeText(baseContext,"fallo",Toast.LENGTH_LONG).show()
                    actualiza(null)

                }
    }
}

}