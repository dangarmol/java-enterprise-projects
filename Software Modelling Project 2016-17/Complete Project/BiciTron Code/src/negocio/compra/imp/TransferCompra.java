package negocio.compra.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TransferCompra 
{
	private int id;
	private int idCliente;
	private double costeTotal;
	private Date fecha;
	private HashMap<Integer, Integer> lineaCompra;
	private String log;
	private boolean activo;

	public TransferCompra(int idCliente, double costeTotal, boolean activo) 
	{
		this.idCliente = idCliente;
		this.costeTotal = costeTotal;
		this.fecha = new java.sql.Date(new java.util.Date().getTime());
		lineaCompra = new HashMap<Integer, Integer>();
		log = "";
		this.activo = activo;
	}

	public TransferCompra(int id, int idCliente, double costeTotal, Date fecha,	boolean activo)
	{
		this.id = id;
		this.idCliente = idCliente;
		this.costeTotal = costeTotal;
		this.fecha = fecha;
		lineaCompra = new HashMap<Integer, Integer>();
		log = "";
		this.activo = activo;
	}

	public int getId()
	{
		return id;
	}

	public int getIdCliente() 
	{
		return idCliente;
	}

	public double getCosteTotal()
	{
		return costeTotal;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public boolean getExisteArticulo(int articulo)
	{
		boolean existe = false;

		if (lineaCompra.containsKey(articulo))
			existe = true;
		return existe;
	}

	public HashMap<Integer, Integer> getLineaCompra() 
	{
		return lineaCompra;
	}

	public boolean getVaciaLineaCompra() 
	{
		return lineaCompra.isEmpty();
	}

	public boolean getActivo() 
	{
		return activo;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}

	public void setCosteTotal(double costeTotal) {
		this.costeTotal = costeTotal;
	}

	public void setFecha(Date fecha) 
	{
		this.fecha = fecha;
	}

	public void setLineaCompra(int articulo, int cantidad)
	{
		if (lineaCompra.containsKey(articulo)) {
			lineaCompra.put(articulo, lineaCompra.get(articulo) + cantidad);

			if (lineaCompra.get(articulo) <= 0)
				lineaCompra.remove(articulo);
		} else
			lineaCompra.put(articulo, cantidad);
	}

	public void removeLineaCompra(int articulo) 
	{
		if (lineaCompra.containsKey(articulo))
			lineaCompra.remove(articulo);
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public String toString() 
	{
		String s = "Id: " + id + " Cliente: " + idCliente + " Coste total: " + costeTotal + " Fecha: " + fecha + " Activo: " + activo + "\nEstas son las compras:\n";
		int contador = 1;
		Iterator<Entry<Integer, Integer>> it = this.lineaCompra.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
			s += contador + ": Articulo: " + t.getKey() + "   Unidades: " + t.getValue() + "\n";
			contador++;
		}

		return s;
	}

	public void setLog(String log)
	{
		this.log += log + "\n";
	}

	public String getLog() 
	{
		return log;
	}
}