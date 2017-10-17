package negocio.bicicleta.imp;

public class TransferBicicletaMontana extends TransferBicicleta 
{
	private String amortiguacion;

	public TransferBicicletaMontana(String material, String marca, double precio, String amortiguacion, boolean activo) 
	{
		super(material, marca, precio, activo);
		this.amortiguacion = amortiguacion;
	}

	public TransferBicicletaMontana(int id, String material, String marca, double precio, String amortiguacion, boolean activo)
	{
		super(id, material, marca, precio, activo);
		this.amortiguacion = amortiguacion;
	}

	public String getAmortiguacion() 
	{
		return amortiguacion;
	}

	public void setAmortiguacion(String amortiguacion) 
	{
		this.amortiguacion = amortiguacion;
	}

	public String toString()
	{
		return "Id: " + id + " Material: " + material + " Marca: " + marca + " Precio: " + precio + " Amortiguacion: " + amortiguacion + " Activo: " + activo;
	}
}