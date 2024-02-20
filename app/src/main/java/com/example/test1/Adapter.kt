package com.example.test1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val productList: List<Productos>): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var onItemClick : ((Productos) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitulo.text = "Nombre: ${productList[position].title}"
        holder.tvDescripcion.text = productList[position].description
        holder.tvPrecio.text = "Precio: ${productList[position].price}"

        holder.cardView.setOnClickListener {
            onItemClick?.invoke(productList[position])
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvName)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescription)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
        val cardView : CardView = itemView.findViewById(R.id.card_view)
    }
}