package Negocio.Aeropuerto.imp;

public class TransferAeropuerto {
	private int id;
	private String nombre;
	private String pais;
	private String ciudad;
	private boolean activo;

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		String cadena = "";
		cadena += "ID del aeropuerto: ";
		cadena += this.id;
		cadena += '\n';
		cadena += "Nombre: ";
		cadena += this.nombre;
		cadena += '\n';
		cadena += "Ubicacion: ";
		cadena += this.ciudad + ", " + this.pais;
		cadena += '\n';
		cadena += "Este aeropuerto ";
		if(this.activo)
			cadena += "ESTA";
		else
			cadena += "NO ESTA";
		cadena += " activo actualmente." + '\n';
		return cadena;
	}
}