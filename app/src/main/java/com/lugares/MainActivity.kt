package com.lugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lugares.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    // el binding  genera una clase de vinculación para cada archivo de diseño XML presente en ese módulo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnHola.setOnClickListener(){
            Toast.makeText(this,"Hola desde android studio", Toast.LENGTH_LONG).show()


        }

        binding.btnDespedida.setOnClickListener(){
            Toast.makeText(this,"Adios desde android studio", Toast.LENGTH_LONG).show()


        }

    }
}