package negocio.bicicleta.imp;

public class TransferBicicletaCarretera extends TransferBicicleta 
{
	private int velocidadMaxima;

	public TransferBicicletaCarretera(String material, String marca, double precio, int velocidadMaxima, boolean activo) 
	{
		super(material, marca, precio, activo);
		this.velocidadMaxima = velocidadMaxima;
	}

	public TransferBicicletaCarretera(int id, String material, String marca, double precio, int velocidadMaxima, boolean activo) 
	{
		super(id, material, marca, precio, activo);
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getVelocidadMaxima()
	{
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) 
	{
		this.velocidadMaxima = velocidadMaxima;
	}

	public String toString() 
	{
		return "Id: " + id + " Material: " + material + " Marca: " + marca + " Precio: " + precio + " Velocidad maxima: " + velocidadMaxima + " Activo: " + activo;
	}
}