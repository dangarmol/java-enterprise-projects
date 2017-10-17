package Negocio.factory;

import Negocio.Aeropuerto.ServicioAplicacionAeropuerto;
import Negocio.Avion.ServicioAplicacionAvion;
import Negocio.Compra.ServicioAplicacionCompra;
import Negocio.InstanciaDeVuelo.ServicioAplicacionInstanciaDeVuelo;
import Negocio.Vuelo.ServicioAplicacionVuelo;


public abstract class FactoryServicioAplicacion {

	private static FactoryServicioAplicacion factoryServicioAplicacion;

	public static FactoryServicioAplicacion getInstance() {
		if(factoryServicioAplicacion == null) {
			factoryServicioAplicacion = new FactoryServicioAplicacionImp();
		}
		return factoryServicioAplicacion;
	}

	public abstract ServicioAplicacionAeropuerto createSAAeropuerto();

	public abstract ServicioAplicacionAvion createSAAvion();

	public abstract ServicioAplicacionCompra createSABilletes();

	public abstract ServicioAplicacionInstanciaDeVuelo createSAInstanciaDeVuelo();

	public abstract ServicioAplicacionVuelo createSAVuelo();
}
