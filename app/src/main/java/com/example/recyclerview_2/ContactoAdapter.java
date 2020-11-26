package com.example.recyclerview_2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.MiViewHolder> {

	private List<Contacto> contactsList;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private final OnItemClickListener listener;
	/**
	 * Clase ViewHolder
	 * */

	// Interfaz que implementaremos para poder recibir los eventos click sobre los items.
	public interface OnItemClickListener {
		void onItemClick(Contacto item);
	}

	// Nuestro ViewHolder con los datos que queremos mostrar.
	public class MiViewHolder extends RecyclerView.ViewHolder {
		public TextView nombreTV;
		public TextView fechaNacimientoTV;

		// Obtenemos los elementos del layout que vamos a modificar y mostrar.
		public MiViewHolder(View view) {
			super(view);
			nombreTV 			= (TextView) view.findViewById(R.id.contactName);
			fechaNacimientoTV 	= (TextView) view.findViewById(R.id.birthday);
		}
	}

	// Constructor del Adaptador.
	public ContactoAdapter(List<Contacto> contactLists, OnItemClickListener listener) {
		this.contactsList 	= contactLists;
		this.listener		= listener;
	}

	// Este metodo es llamado por el RecyclerView para mostrar los datos del elemento de esa posición.
	@Override
	public void onBindViewHolder(MiViewHolder holder, int posicion) {
		Contacto c 	= contactsList.get(posicion);
		holder.nombreTV.setText(c.getNombre());
		holder.fechaNacimientoTV.setText(df.format(c.getFechaNacimiento()));
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onItemClick(c);
			}
		});
	}

	@Override
	public int getItemCount() {
		return contactsList.size();
	}

	// A este metodo se le llama cuando necesitamos crear una nueva linea para el RecyclerView.
	@Override
	public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linea,parent, false);
		return new MiViewHolder(v);
	}

}
