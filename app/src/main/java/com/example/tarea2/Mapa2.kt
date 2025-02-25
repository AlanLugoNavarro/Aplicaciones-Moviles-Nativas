package com.example.tarea2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Mapa2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapa2)

        val botonArriba = findViewById<ImageButton>(R.id.ibtn_arriba1);
        val botonDerecha = findViewById<ImageButton>(R.id.ibtn_der1);
        val botonAbajo = findViewById<ImageButton>(R.id.ibtn_ab1);
        val botonIzquierda = findViewById<ImageButton>(R.id.ibtn_izq1);
        val botonSalir = findViewById<Button>(R.id.btn_Salir1);

        botonArriba.setOnClickListener {
            val intent = Intent(this, Mapa5::class.java)
            startActivity(intent)
        }

        botonIzquierda.setOnClickListener {
            val intent = Intent(this, Mapa3::class.java)
            startActivity(intent)
        }

        botonDerecha.setOnClickListener{
            val intent = Intent(this, Mapa4::class.java)
            startActivity(intent)
        }
        botonAbajo.setOnClickListener{
            val intent = Intent(this, Mapa1::class.java)
            startActivity(intent)
        }

        botonSalir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}