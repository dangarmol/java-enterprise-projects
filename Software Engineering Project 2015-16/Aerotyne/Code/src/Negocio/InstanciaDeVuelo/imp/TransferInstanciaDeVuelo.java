package Negocio.InstanciaDeVuelo.imp;

public class TransferInstanciaDeVuelo {

	private int id;
	private int plazasLibres;
	private String fecha;
	private int avion;
	private int vuelo;
	private boolean activo;

	public int getId() {
		return this.id;
	}

	public int getVuelo() {
		return this.vuelo;
	}

	public int getAvion() {
		return this.avion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public int getPlazasLibres() {
		return this.plazasLibres;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public void setAvion(int avion) {
		this.avion = avion;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setPlazasLibres(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		String cadena = "";
		cadena += "ID de la Instancia de vuelo: ";
		cadena += this.id;
		cadena += '\n';
		cadena += "ID de Vuelo asociado: ";
		cadena += this.vuelo;
		cadena += '\n';
		cadena += "ID de avión asociado: ";
		cadena += this.avion;
		cadena += '\n';
		cadena += "Con fecha: ";
		cadena += this.fecha;
		cadena += '\n';
		cadena += "(Tiene ";
		cadena += this.plazasLibres;
		cadena += " plazas libres.)";
		cadena += '\n';
		cadena += "Esta instancia ";
		if(this.activo)
			cadena += "ESTÁ";
		else
			cadena += "NO ESTÁ";
		cadena += " activa actualmente.";
		return cadena;
	}
}