package negocio.compra.imp;

import integracion.factoria.FactoriaDAO;
import integracion.transactionManager.TransactionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import presentacion.controlador.Contexto;

import negocio.bicicleta.imp.TransferBicicleta;
import negocio.cliente.imp.TransferCliente;
import negocio.compra.ServicioAplicacionCompra;

public class ServicioAplicacionCompraImp implements ServicioAplicacionCompra 
{
	public TransferCompra iniciarCompra(int id) 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCompra tCompra = null;
		TransferCliente tCliente = FactoriaDAO.getInstance().createDAOCliente().searchId(id);

		if (tCliente != null && tCliente.getActivo())
			tCompra = new TransferCompra(tCliente.getId(), 0, true);

		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();

		return tCompra;
	}

	public Contexto agregarArticulo(Contexto articulo) 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferBicicleta tBicicleta = FactoriaDAO.getInstance().createDAOBicicleta().searchId(articulo.getEvent());

		if (tBicicleta == null || !tBicicleta.getActivo())
			articulo = null;

		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();

		return articulo;
	}

	public int devolverArticulo(TransferLineaCompra tLineaCompra) 
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferLineaCompra lineaCompraAlmacenada = FactoriaDAO.getInstance().createDAOCompra().searchLineaCompra(tLineaCompra);

		if (lineaCompraAlmacenada != null && lineaCompraAlmacenada.getActivo()) 
		{
			TransferCompra tCompraId = FactoriaDAO.getInstance().createDAOCompra().searchId(tLineaCompra.getIdCompra());
			int cantidadDevolucion = lineaCompraAlmacenada.getCantidad() - tLineaCompra.getCantidad();

			if (cantidadDevolucion <= 0) 
			{
				tLineaCompra.setCantidad(lineaCompraAlmacenada.getCantidad()); // asi sabemos cuantas tenemos que quitar del precio total de la compra
				tLineaCompra.setCantidadNueva(0);
				tLineaCompra.setActivo(false);
				id = -3;
			} 
			else 
			{
				tLineaCompra.setCantidadNueva(cantidadDevolucion);
				id = -2;
			}

			int auxResultado = FactoriaDAO.getInstance().createDAOCompra().devolucionArticulo(tCompraId, tLineaCompra);

			if (auxResultado == 0)
			{
				TransactionManager.getInstance().getTransaccion().rollback();
				id = 0;
			}
			else
				TransactionManager.getInstance().getTransaccion().commit();
		} 
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

	public TransferCompra detalleCompra(int id) 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCompra t = FactoriaDAO.getInstance().createDAOCompra().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	public ArrayList<TransferCompra> listaCompra() 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCompra> lista = FactoriaDAO.getInstance().createDAOCompra().list();
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}

	@Override
	public TransferCompra finalizarCompra(TransferCompra tCompra) 
	{
		ArrayList<Integer> articulosQuitar = new ArrayList<Integer>();
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();

		Iterator<Entry<Integer, Integer>> it = tCompra.getLineaCompra().entrySet().iterator();

		while (it.hasNext()) 
		{
			Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
			TransferBicicleta tb = FactoriaDAO.getInstance().createDAOBicicleta().searchId(t.getKey());

			if (tb == null || !tb.getActivo())
			{
				tCompra.setLog("Articulo: " + t.getKey() + " no ha podido ser agregado");
				articulosQuitar.add(t.getKey());
			} 
			else 
			{
				tCompra.setLog("Articulo: " + t.getKey() + " ha podido ser agregado");
				tCompra.setCosteTotal(tCompra.getCosteTotal() + tb.getPrecio() * t.getValue());
			}
		}

		for (int i = 0; i < articulosQuitar.size(); ++i)
			tCompra.removeLineaCompra(articulosQuitar.get(i));

		int resultado = FactoriaDAO.getInstance().createDAOCompra().add(tCompra);

		if (resultado == 0) 
		{
			tCompra = null;
			TransactionManager.getInstance().getTransaccion().rollback();
		} 
		else
			TransactionManager.getInstance().getTransaccion().commit();

		TransactionManager.getInstance().eliminaTransaccion();
		return tCompra;
	}
}