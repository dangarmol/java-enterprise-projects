package Negocio.Aeropuerto.imp;

public class TransferAeropuertoNoSeguro extends TransferAeropuerto {
	
	private String descripcion;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String toString() {
		String cadena = super.toString();
		cadena += "Este aeropuerto NO tiene asociado un grado de seguridad." + '\n';
		cadena += "Descripcion del aeropuerto: ";
		cadena += this.descripcion;
		return cadena;
	}
}