package Negocio.Avion.imp;

public class TransferAvion {
	private int id;
	private String modelo;
	private String matricula;
	private int numPlazas;
	private boolean activo;

	public int getId() {
		return this.id;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public boolean getActivo() {
		return activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		String cadena = "";
		cadena += "ID del avi�n: ";
		cadena += this.id;
		cadena += '\n';
		cadena += "Matr�cula: ";
		cadena += this.matricula;
		cadena += '\n';
		cadena += "Modelo de avi�n: ";
		cadena += this.modelo;
		cadena += '\n';
		cadena += " (Contiene ";
		cadena += this.numPlazas;
		cadena += " asientos.)";
		cadena += '\n';
		cadena += "Esta aeronave ";
		if(this.activo)
			cadena += "EST�";
		else
			cadena += "NO EST�";
		cadena += " activa actualmente.";
		return cadena;
	}
}