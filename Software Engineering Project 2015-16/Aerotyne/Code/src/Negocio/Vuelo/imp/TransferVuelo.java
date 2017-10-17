package Negocio.Vuelo.imp;

public class TransferVuelo {
	private int id;
	private int aeropuertoOrigen;
	private int aeropuertoDestino;
	private String diaSemana;
	private String hora;
	private boolean activo;

	public int getId() {
		return this.id;
	}

	public int getOrigen() {
		return this.aeropuertoOrigen;
	}

	public int getDestino() {
		return this.aeropuertoDestino;
	}

	public String getDiaSemana() {
		return this.diaSemana;
	}

	public String getHora() {
		return this.hora;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setOrigen(int origen) {
		this.aeropuertoOrigen = origen;
	}

	public void setDestino(int destino) {
		this.aeropuertoDestino = destino;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		String cadena = "";
		cadena += "ID del Vuelo: ";
		cadena += this.id;
		cadena += '\n';
		cadena += "ID del Aeropuerto Origen asociado: ";
		cadena += this.aeropuertoOrigen;
		cadena += '\n';
		cadena += "ID del Aeropuerto Destino asociado: ";
		cadena += this.aeropuertoDestino;
		cadena += '\n';
		cadena += "El vuelo se realiza cada ";
		cadena += this.diaSemana;
		cadena += '\n';
		cadena += "a las ";
		cadena += this.hora;
		cadena += '\n';
		cadena += "Este vuelo ";
		if(this.activo)
			cadena += "ESTA";
		else
			cadena += "NO ESTA";
		cadena += " activo actualmente.";
		return cadena;
	}
}