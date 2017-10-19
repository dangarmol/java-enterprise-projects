package negocio.bicicleta.imp;

import java.util.ArrayList;

import presentacion.ListaComandos;
import presentacion.controlador.PareadoQuery;
import integracion.factoria.FactoriaDAO;
import integracion.query.factory.FactoriaQuery;
import integracion.transactionManager.TransactionManager;
import negocio.bicicleta.ServicioAplicacionBicicleta;
import negocio.cliente.imp.TransferCliente;

public class ServicioAplicacionBicicletaImp implements ServicioAplicacionBicicleta 
{
	public int altaBicicleta(TransferBicicleta t) 
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferBicicleta tb = FactoriaDAO.getInstance().createDAOBicicleta().search(t);

		if (tb == null)
		{
			id = FactoriaDAO.getInstance().createDAOBicicleta().add(t);
			if (id == 0)
				TransactionManager.getInstance().getTransaccion().rollback();
			else
				TransactionManager.getInstance().getTransaccion().commit();
		} 
		else if (!tb.getActivo()) 
		{
			tb.setActivo(true);
			id = FactoriaDAO.getInstance().createDAOBicicleta().update(tb);

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

	public int bajaBicicleta(int idEntrada) 
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();

		TransferBicicleta tb = FactoriaDAO.getInstance().createDAOBicicleta().searchId(idEntrada);

		if (tb != null) 
		{
			if (tb.getActivo()) 
			{
				tb.setActivo(false);
				id = FactoriaDAO.getInstance().createDAOBicicleta().update(tb);
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

	public int modificarBicicleta(TransferBicicleta t) 
	{
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferBicicleta tExist = FactoriaDAO.getInstance().createDAOBicicleta().searchId(t.getId());

		if (tExist != null) 
		{
			if (tExist.getActivo()) 
			{
				TransferBicicleta tExistMarca = FactoriaDAO.getInstance().createDAOBicicleta().search(t);

				if (tExistMarca == null	|| tExistMarca.getId() == tExist.getId()) 
				{
					if ((t instanceof TransferBicicletaCarretera && tExist instanceof TransferBicicletaCarretera) || (t instanceof TransferBicicletaMontana && tExist instanceof TransferBicicletaMontana)) 
					{
						id = FactoriaDAO.getInstance().createDAOBicicleta().update(t);
						
						if (id == 0)
							TransactionManager.getInstance().getTransaccion().rollback();
						else
							TransactionManager.getInstance().getTransaccion().commit();
					} 
					else
						id = -4;
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

	public TransferBicicleta detalleBicicleta(int id) 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferBicicleta t = FactoriaDAO.getInstance().createDAOBicicleta().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	public ArrayList<TransferBicicleta> listaBicicleta() 
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferBicicleta> lista = FactoriaDAO.getInstance().createDAOBicicleta().list();
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}

	@Override
	public int numeroBicicletas(PareadoQuery pQuery)
	{
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();

		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId((int) pQuery.getPrimeroObjeto());
		int id = 0;

		if (tExist != null)
			id = (int) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIOCANTIDADBICICLETASQUERY).execute(pQuery);
		else
			id = -1;

		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
}