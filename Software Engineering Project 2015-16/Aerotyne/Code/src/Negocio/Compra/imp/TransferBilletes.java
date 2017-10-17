package Negocio.Compra.imp;

public class TransferBilletes {
	private int id;
	private int numBillete;
	private String dni;
	private String nombre;
	private int instanciaDeVuelo;
	private boolean activo;
	private double precio;

	public int getId() {
		return this.id;
	}
	
	public int getNumBillete() {
		return this.numBillete;
	}

	public int getInstanciaDeVuelo() {
		return this.instanciaDeVuelo;
	}
	
	public double getPrecio() {
		return this.precio;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setNumBillete (int num) {
		this.numBillete = num;
	}

	public void setInstanciaDeVuelo(int instancia) {
		this.instanciaDeVuelo = instancia;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		String cadena = "";
		cadena += "ID del Billete: ";
		cadena += this.id;
		cadena += '\n';
		cadena += "ID de la Instancia de Vuelo asociada: ";
		cadena += this.instanciaDeVuelo;
		cadena += '\n';
		cadena += "Nombre y DNI del cliente: ";
		cadena += this.nombre;
		cadena += '\n';
		cadena += "(";
		cadena += this.dni;
		cadena += ")";
		cadena += '\n';
		cadena += "Este billete ";
		if(this.activo)
			cadena += "ESTÁ";
		else
			cadena += "NO ESTÁ";
		cadena += " activo actualmente.";
		return cadena;
	}
}