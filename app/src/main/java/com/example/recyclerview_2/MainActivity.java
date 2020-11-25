package com.example.recyclerview_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	RecyclerView oRecyclerView;
	ArrayList<Contacto> contactoArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Llenar el ArrayList.
		contactoArrayList = new ArrayList<Contacto>();
		for (int i=0;i<100;i++) {
			contactoArrayList.add(new Contacto());
		}

		oRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		//  inicializar el adapter con nuestros datos.
		ContactoAdapter ca = new ContactoAdapter(contactoArrayList);
		oRecyclerView.setAdapter(ca);
		// establecer el Layout Manager.
		LinearLayoutManager llm = new LinearLayoutManager(this);
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		oRecyclerView.setLayoutManager(llm);

	}
}