package integracion.factoria;

import integracion.bicicleta.DaoBicicleta;
import integracion.cliente.DaoCliente;
import integracion.compra.DaoCompra;

public abstract class FactoriaDAO 
{
	private static FactoriaDAO factoriaDao;

	public static synchronized FactoriaDAO getInstance() 
	{
		if (factoriaDao == null)
			factoriaDao = new FactoriaDAOImp();
		return factoriaDao;
	}

	public abstract DaoBicicleta createDAOBicicleta();
	public abstract DaoCliente createDAOCliente();
	public abstract DaoCompra createDAOCompra();
}