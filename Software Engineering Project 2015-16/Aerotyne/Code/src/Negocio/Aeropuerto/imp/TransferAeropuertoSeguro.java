package Negocio.Aeropuerto.imp;

public class TransferAeropuertoSeguro extends TransferAeropuerto {
	
	private int gradoSeguridad;

	public void setGradoSeguridad(int gradoSeguridad) {
		this.gradoSeguridad = gradoSeguridad;
	}

	public int getGradoSeguridad() {
		return this.gradoSeguridad;
	}
	
	public String toString() {
		String cadena = super.toString();
		cadena += "El grado de seguridad de este aeropuerto es: " + this.gradoSeguridad + '\n';
		return cadena;
	}
}