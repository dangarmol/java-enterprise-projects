package negocio.cliente.imp;

import java.util.ArrayList;
import presentacion.ListaComandos;
import presentacion.controlador.PareadoQuery;
import integracion.factoria.FactoriaDAO;
import integracion.query.factory.FactoriaQuery;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.ServicioAplicacionCliente;

public class ServicioAplicacionClienteImp implements ServicioAplicacionCliente 
{
	public int altaCliente(TransferCliente t)
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().search(t);

		if (tc == null) 
		{
			id = FactoriaDAO.getInstance().createDAOCliente().add(t);
			if (id == 0)
				TransactionManager.getInstance().getTransaccion().rollback();
			else
				TransactionManager.getInstance().getTransaccion().commit();
		}
		else if (!tc.getActivo())
		{
			tc.setActivo(true);
			id = FactoriaDAO.getInstance().createDAOCliente().update(tc);

			if (id == 0)
				TransactionManager.getInstance().getTransaccion().rollback();
			else 
			{
				TransactionManager.getInstance().getTransaccion().commit();
				id = -2;
			}
		}
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

	public int bajaCliente(int idEntrada)
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().searchId(idEntrada);

		if (tc != null) 
		{
			if (tc.getActivo()) 
			{
				tc.setActivo(false);
				id = FactoriaDAO.getInstance().createDAOCliente().update(tc);
				if (id == 0)
					TransactionManager.getInstance().getTransaccion().rollback();
				else
					TransactionManager.getInstance().getTransaccion().commit();
			} 
			else
				id = -2;
		} 
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

	public int modificarCliente(TransferCliente t) 
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId(t.getId());

		if (tExist != null) 
		{
			if (tExist.getActivo()) 
			{
				TransferCliente tExistTarjeta = FactoriaDAO.getInstance().createDAOCliente().search(t);

				if (tExistTarjeta == null || tExistTarjeta.getId() == tExist.getId()) 
				{
					id = FactoriaDAO.getInstance().createDAOCliente().update(t);
					if (id == 0)
						TransactionManager.getInstance().getTransaccion().rollback();
					else
						TransactionManager.getInstance().getTransaccion().commit();
				} 
				else
					id = -3;
			} 
			else
				id = -2;
		}
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

	public TransferCliente detalleCliente(int id) 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente t = FactoriaDAO.getInstance().createDAOCliente().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	public ArrayList<TransferCliente> listaCliente()
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = FactoriaDAO.getInstance().createDAOCliente().list();
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TransferCliente> numeroClientes(PareadoQuery pQuery)
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = (ArrayList<TransferCliente>) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIONUMEROCLIENTESQUERY).execute(pQuery);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
}