package com.example.ejerciciocalificable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private final List<Producto> listaProductos;

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_producto);
            nombre = itemView.findViewById(R.id.nombre_producto);
            precio = itemView.findViewById(R.id.precio_producto);
        }
    }

    public ProductoAdapter(List<Producto> productos) {
        this.listaProductos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto productoActual = listaProductos.get(position);
        holder.imagen.setImageResource(productoActual.getImagen());
        holder.nombre.setText(productoActual.getNombre());
        holder.precio.setText(String.valueOf(productoActual.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
