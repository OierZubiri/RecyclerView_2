package com.example.recyclerview_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.MyViewHolder> {

	private List<Contacto> contactsList;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * View holder class
	 * */
	public class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView nombreTV;
		public TextView fechaNacimientoTV;

		public MyViewHolder(View view) {
			super(view);
			nombreTV 			= (TextView) view.findViewById(R.id.contactName);
			fechaNacimientoTV 	= (TextView) view.findViewById(R.id.birthday);
		}
	}

	public ContactoAdapter(List<Contacto> contactLists) {
		this.contactsList = contactLists;
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		Contacto c 	= contactsList.get(position);
		holder.nombreTV.setText(c.getNombre());
		holder.fechaNacimientoTV.setText(df.format(c.getFechaNacimiento()));
	}

	@Override
	public int getItemCount() {
		return contactsList.size();
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linea,parent, false);
		return new MyViewHolder(v);
	}

}
