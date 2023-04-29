package com.example.tp2_punto2

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ConsultarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultar)
        ciudadDBHELPER = miSQLiteHelper(this)

        var btn = findViewById<Button>(R.id.btnConsultar)
        btn.setOnClickListener{
            var consulta = findViewById<TextView>(R.id.ciudad_consulta).text.toString()
            val datalist = ciudadDBHELPER.getDataByCity(consulta)
            if (datalist != null){
                findViewById<TextView>(R.id.ciudad).setText(datalist[0] as String)
                findViewById<TextView>(R.id.pais).setText(datalist[1] as String)
                findViewById<TextView>(R.id.poblacion).setText(datalist[2].toString())
            }
            else
            {
                Toast.makeText(this, "No se encontro la capital", Toast.LENGTH_SHORT).show()
            }
        }


    }
}