package com.example.recyclerview_2;

import java.util.Date;

public class Contacto {
	private String nombre;
	private Date fechaNacimiento;
	static int  iKont;

	// Este constructor es solo para poder llenar la lista con datos.
	public Contacto() {
		this.nombre = "Oier " + iKont++;
		this.fechaNacimiento = new Date();
	}

	public Contacto(String pNombre, Date pFechaNacimiento) {
		this.nombre = pNombre;
		this.fechaNacimiento = pFechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
