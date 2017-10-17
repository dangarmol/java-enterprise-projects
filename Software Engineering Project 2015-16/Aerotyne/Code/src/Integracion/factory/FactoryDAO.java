package Integracion.factory;

import Integracion.Aeropuerto.DaoAeropuerto;
import Integracion.Avion.DaoAvion;
import Integracion.Compra.DaoCompra;
import Integracion.InstanciaDeVuelo.DaoInstanciaDeVuelo;
import Integracion.Vuelo.DaoVuelo;

public abstract class FactoryDAO {

	private static FactoryDAO factoryDao = null;

	public static FactoryDAO getInstance() {
		
		if (factoryDao == null) {
			factoryDao = new FactoryDAOImp();
		}
		return factoryDao;
		
	}

	public abstract DaoAeropuerto createDAOAeropuerto();

	public abstract DaoAvion createDAOAvion();

	public abstract DaoCompra createDAOBilletes();

	public abstract DaoInstanciaDeVuelo createDAOInstanciaDeVuelo();

	public abstract DaoVuelo createDAOVuelo();
}