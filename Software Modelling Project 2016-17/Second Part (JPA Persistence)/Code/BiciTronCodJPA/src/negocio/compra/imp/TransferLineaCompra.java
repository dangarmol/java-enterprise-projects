package negocio.compra.imp;

public class TransferLineaCompra
{
	private int idCompra;
	private int idArticulo;
	private int cantidad;
	private int cantidadNueva;
	private boolean activo;

	public TransferLineaCompra(int idCompra, int idArticulo, int cantidad) 
	{
		this.idCompra = idCompra;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
		activo = true;
	}

	public TransferLineaCompra(int idCompra, int idArticulo, int cantidad, boolean activo) 
	{
		this.idCompra = idCompra;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
		this.activo = activo;
	}

	public int getIdCompra() 
	{
		return idCompra;
	}

	public int getIdArticulo() 
	{
		return idArticulo;
	}

	public int getCantidad() 
	{
		return cantidad;
	}

	public int getCantidadNueva() 
	{
		return cantidadNueva;
	}

	public boolean getActivo() 
	{
		return activo;
	}

	public void setIdCompra(int idCompra) 
	{
		this.idCompra = idCompra;
	}

	public void setIdArticulo(int idArticulo)
	{
		this.idArticulo = idArticulo;
	}

	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}

	public void setCantidadNueva(int cantidadNueva)
	{
		this.cantidadNueva = cantidadNueva;
	}

	public void setActivo(boolean activo) 
	{
		this.activo = activo;
	}
}
