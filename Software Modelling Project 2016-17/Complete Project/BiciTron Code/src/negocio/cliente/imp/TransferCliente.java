package negocio.cliente.imp;

public class TransferCliente
{
	private int id;
	private String nombre;
	private String tarjetaDeCredito;
	private boolean activo;

	public TransferCliente(String nombre, String tarjetaDeCredito, boolean activo) 
	{
		this.nombre = nombre;
		this.tarjetaDeCredito = tarjetaDeCredito;
		this.activo = activo;
	}

	public TransferCliente(int id, String nombre, String tarjetaDeCredito, boolean activo) 
	{
		this.id = id;
		this.nombre = nombre;
		this.tarjetaDeCredito = tarjetaDeCredito;
		this.activo = activo;
	}

	public int getId() 
	{
		return this.id;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String getTarjetaDeCredito()
	{
		return this.tarjetaDeCredito;
	}

	public boolean getActivo() 
	{
		return this.activo;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setTarjetaDeCredito(String tarjeta) 
	{
		this.tarjetaDeCredito = tarjeta;
	}

	public void setActivo(boolean activo) 
	{
		this.activo = activo;
	}

	public String toString()
	{
		return "Id: " + id + " Nombre: " + nombre + " Tarjeta de credito: " + tarjetaDeCredito + " Activo: " + activo;
	}
}