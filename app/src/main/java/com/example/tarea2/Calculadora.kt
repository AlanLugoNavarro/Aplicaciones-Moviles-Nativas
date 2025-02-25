package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2.MainActivity
import com.example.tarea2.R

class Calculadora : AppCompatActivity() {
    private var num1: Int = 0;
    private var num2: Int = 0;
    private var operacion: String = "";
    private lateinit var numero: EditText;
    private lateinit var mostrarCuenta: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora)

        numero = findViewById<EditText>(R.id.et_Numero);
        val boton9 = findViewById<Button>(R.id.btn_9);
        val boton8 = findViewById<Button>(R.id.btn_8);
        val boton7 = findViewById<Button>(R.id.btn_7);
        val boton6 = findViewById<Button>(R.id.btn_6);
        val boton5 = findViewById<Button>(R.id.btn_5);
        val boton4 = findViewById<Button>(R.id.btn_4);
        val boton3 = findViewById<Button>(R.id.btn_3);
        val boton2 = findViewById<Button>(R.id.btn_2);
        val boton1 = findViewById<Button>(R.id.btn_1);
        val boton0 = findViewById<Button>(R.id.btn_0);
        val botonCe = findViewById<Button>(R.id.btn_Ce);
        val botonSuma = findViewById<Button>(R.id.btn_Suma);
        val botonResta = findViewById<Button>(R.id.btn_Resta);
        val botonMultiplicacion = findViewById<Button>(R.id.btn_Multi);
        val botonDivision = findViewById<Button>(R.id.btn_Div);
        val botonIgual = findViewById<Button>(R.id.btn_Igual);
        val botonEliminar = findViewById<Button>(R.id.btn_Eliminar);
        mostrarCuenta = findViewById<TextView>(R.id.tv_cuenta);
        val botonSalir = findViewById<Button>(R.id.btn_Salir);

        val onClickListenerNum = View.OnClickListener { view ->
            val idStr = resources.getResourceEntryName(view.id);
            val ultimoCaracter = idStr.last();
            numeroB(ultimoCaracter.toString());
        }
        boton9.setOnClickListener(onClickListenerNum);
        boton8.setOnClickListener(onClickListenerNum);
        boton7.setOnClickListener(onClickListenerNum);
        boton6.setOnClickListener(onClickListenerNum);
        boton5.setOnClickListener(onClickListenerNum);
        boton4.setOnClickListener(onClickListenerNum);
        boton3.setOnClickListener(onClickListenerNum);
        boton2.setOnClickListener(onClickListenerNum);
        boton1.setOnClickListener(onClickListenerNum);
        boton0.setOnClickListener(onClickListenerNum);

        val onClickListenerOp = View.OnClickListener { view ->
            when(view.id){
                R.id.btn_Suma -> {
                    operacionB("+");
                }
                R.id.btn_Resta -> {
                    operacionB("-");
                }
                R.id.btn_Multi -> {
                    operacionB("x");
                }
                R.id.btn_Div -> {
                    operacionB("/");
                }
            }
        }
        botonSuma.setOnClickListener(onClickListenerOp);
        botonResta.setOnClickListener(onClickListenerOp);
        botonMultiplicacion.setOnClickListener(onClickListenerOp);
        botonDivision.setOnClickListener(onClickListenerOp);

        botonIgual.setOnClickListener {
            Resolver();
            numero.setText(num1.toString());
            mostrarCuenta.setText("");
        }
        botonCe.setOnClickListener {
            Limpiar();
        }
        botonEliminar.setOnClickListener {
            Borrar();
        }

        botonSalir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun numeroB(num: String){
        numero.setText(numero.text.toString()+num);
    }
    private fun operacionB(op: String){
        if(numero.text.toString() != ""){
            if(operacion == ""){
                operacion = op;
                num1 = numero.text.toString().toInt();
                mostrarCuenta.setText(num1.toString() + op);
                numero.setText("");
            }else{
                Resolver();
                numero.setText("");
                operacion = op;
                mostrarCuenta.setText(num1.toString() + op);
            }
        }else{
            Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
        }
    }
    private fun Resolver(){
        if(numero.text.toString() != ""){
            when(operacion){
                "+" -> {
                    num1 += numero.text.toString().toInt();
                }
                "-" -> {
                    num1 -= numero.text.toString().toInt();
                }
                "x" -> {
                    num1 *= numero.text.toString().toInt();
                }
                "/" -> {
                    if(numero.text.toString().toInt() == 0){
                        Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        num1 /= numero.text.toString().toInt();
                    }
                }
            }

            operacion = "";
        }else{
            Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
        }
    }
    private fun Limpiar(){
        num1 = 0;
        num2 = 0;
        operacion = "";
        numero.setText("");
        mostrarCuenta.setText("");
    }
    private fun Borrar(){
        if(numero.text.toString() != ""){
            val texto = numero.text.toString();
            numero.setText(texto.substring(0, texto.length - 1));
        }
    }
}