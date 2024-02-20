package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Detalles_productos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_productos)
        val producto = intent.getParcelableExtra<Productos>("product")
        if (producto != null){
            val tvTitulo : TextView = findViewById(R.id.tvTitulo)
            val tvDescripcion : TextView = findViewById(R.id.tvDescriptionDetalle)
            val tvDetalle : TextView = findViewById(R.id.tvPrecioDetalle)
            val image = findViewById<ImageView>(R.id.imageExample)
            val button = findViewById<Button>(R.id.buttonClose)

            tvTitulo.text = producto.title
            tvDescripcion.text = "Descripcion: ${producto.description}"
            tvDetalle.text = "Precio ${producto.price.toString()}"
            Picasso.get().load(producto.thumbnail.toString()).into(image)

            button.setOnClickListener {
                finish()
            }
        }
    }
}