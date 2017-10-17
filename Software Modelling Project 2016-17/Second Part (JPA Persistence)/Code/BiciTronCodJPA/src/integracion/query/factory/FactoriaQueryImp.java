package integracion.query.factory;

import integracion.query.Query;
import integracion.query.imp.CantidadBicicletasQuery;
import integracion.query.imp.NumeroClientesQuery;
import presentacion.ListaComandos;

public class FactoriaQueryImp extends FactoriaQuery
{
	@Override
	public Query getQuery(int event) 
	{
		Query query = null;
		
		switch(event)
		{
			case ListaComandos.NEGOCIONUMEROCLIENTESQUERY:
				query = new NumeroClientesQuery();
				break;
			case ListaComandos.NEGOCIOCANTIDADBICICLETASQUERY:
				query = new CantidadBicicletasQuery();
				break;
		}
		
		return query;
	}
}