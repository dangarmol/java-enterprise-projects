package integracion.query.factory;

import integracion.query.Query;

public abstract class FactoriaQuery 
{
	private static FactoriaQuery instancia;

	public static synchronized FactoriaQuery getInstance() 
	{
		if(instancia == null)
			instancia = new FactoriaQueryImp();
		return instancia;
	}

	public abstract Query getQuery(int event);
}