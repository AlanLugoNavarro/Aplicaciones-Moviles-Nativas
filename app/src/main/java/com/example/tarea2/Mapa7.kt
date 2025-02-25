package com.example.tarea2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Mapa7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapa7)

        val botonArriba = findViewById<ImageButton>(R.id.ibtn_arriba1);
        val botonDerecha = findViewById<ImageButton>(R.id.ibtn_der1);
        val botonAbajo = findViewById<ImageButton>(R.id.ibtn_ab1);
        val botonIzquierda = findViewById<ImageButton>(R.id.ibtn_izq1);
        val botonSalir = findViewById<Button>(R.id.btn_Salir1);

        botonArriba.setOnClickListener {
            val intent = Intent(this, Mapa8::class.java)
            startActivity(intent)
        }
        botonDerecha.setOnClickListener {
            val intent = Intent(this, Mapa6::class.java)
            startActivity(intent)
        }

        val sinCamino = View.OnClickListener { view ->
            Toast.makeText(this, "No hay camino", Toast.LENGTH_SHORT).show();
        }
        botonIzquierda.setOnClickListener(sinCamino);
        botonAbajo.setOnClickListener(sinCamino);

        botonSalir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}