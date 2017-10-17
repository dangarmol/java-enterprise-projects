package integracion.factoria;

import integracion.bicicleta.DaoBicicleta;
import integracion.bicicleta.imp.DaoBicicletaImp;
import integracion.cliente.DaoCliente;
import integracion.cliente.imp.DaoClienteImp;
import integracion.compra.DaoCompra;
import integracion.compra.imp.DaoCompraImp;

public class FactoriaDAOImp extends FactoriaDAO
{
	@Override
	public DaoBicicleta createDAOBicicleta() 
	{
		return new DaoBicicletaImp();
	}

	@Override
	public DaoCliente createDAOCliente()
	{
		return new DaoClienteImp();
	}

	@Override
	public DaoCompra createDAOCompra() 
	{
		return new DaoCompraImp();
	}
}