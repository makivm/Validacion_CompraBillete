package modelo;

import java.util.Objects;

public class Billete {
	private String nombre;
	private int edad;
	private int billete;
	private String dni;
	private int pasajeros;
	private boolean idayVuelta;
	
	public Billete() {
		this.billete=1;
		idayVuelta=false;
		this.nombre="";
		this.dni="";
	}

	public Billete(String nombre, int edad, int billete, String dni, int pasajeros, boolean idayVuelta) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.billete = billete;
		this.dni = dni;
		this.pasajeros = pasajeros;
		this.idayVuelta = idayVuelta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getBillete() {
		return billete;
	}

	public void setBillete(int billete) {
		this.billete = billete;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}

	public boolean isIdayVuelta() {
		return idayVuelta;
	}

	public void setIdayVuelta(boolean idayVuelta) {
		this.idayVuelta = idayVuelta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billete other = (Billete) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Billete [nombre=" + nombre + ", edad=" + edad + ", billete=" + billete + ", dni=" + dni + ", pasajeros="
				+ pasajeros + ", idayVuelta=" + idayVuelta + "]";
	}
	
	public double getImporteTotal() {
		double precio=30;
		if (this.billete==2) {
			precio=precio*0.8;
		}else if(this.billete==3){
			precio=precio*0.65;
		}else if(idayVuelta) {
			precio=2*(precio*0.85);
		}
		return precio*this.pasajeros;
	}
	
	
	
	
}
