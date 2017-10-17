package Integracion.factory;

import Integracion.Aeropuerto.DaoAeropuerto;
import Integracion.Aeropuerto.imp.DaoAeropuertoImp;
import Integracion.Avion.DaoAvion;
import Integracion.Avion.imp.DaoAvionImp;
import Integracion.Compra.DaoCompra;
import Integracion.Compra.imp.DaoCompraImp;
import Integracion.InstanciaDeVuelo.DaoInstanciaDeVuelo;
import Integracion.InstanciaDeVuelo.imp.DaoInstanciaDeVueloImp;
import Integracion.Vuelo.DaoVuelo;
import Integracion.Vuelo.imp.DaoVueloImp;

public class FactoryDAOImp extends FactoryDAO {

	@Override
	public DaoAeropuerto createDAOAeropuerto() {
		return new DaoAeropuertoImp();
	}

	@Override
	public DaoAvion createDAOAvion() {
		return new DaoAvionImp();
	}

	@Override
	public DaoCompra createDAOBilletes() {
		return new DaoCompraImp();
	}

	@Override
	public DaoInstanciaDeVuelo createDAOInstanciaDeVuelo() {
		return new DaoInstanciaDeVueloImp();
	}

	@Override
	public DaoVuelo createDAOVuelo() {
		return new DaoVueloImp();
	}
}