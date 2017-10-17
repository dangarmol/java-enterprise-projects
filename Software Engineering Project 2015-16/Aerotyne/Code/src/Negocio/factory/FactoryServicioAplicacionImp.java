package Negocio.factory;

import Negocio.Aeropuerto.ServicioAplicacionAeropuerto;
import Negocio.Aeropuerto.imp.ServicioAplicacionAeropuertoImp;
import Negocio.Avion.ServicioAplicacionAvion;
import Negocio.Avion.imp.ServicioAplicacionAvionImp;
import Negocio.Compra.ServicioAplicacionCompra;
import Negocio.Compra.imp.ServicioAplicacionCompraImp;
import Negocio.InstanciaDeVuelo.ServicioAplicacionInstanciaDeVuelo;
import Negocio.InstanciaDeVuelo.imp.ServicioAplicacionInstanciaDeVueloImp;
import Negocio.Vuelo.ServicioAplicacionVuelo;
import Negocio.Vuelo.imp.ServicioAplicacionVueloImp;

public class FactoryServicioAplicacionImp extends FactoryServicioAplicacion {

	@Override
	public ServicioAplicacionAeropuerto createSAAeropuerto() {
		return new ServicioAplicacionAeropuertoImp();
	}

	@Override
	public ServicioAplicacionAvion createSAAvion() {
		return new ServicioAplicacionAvionImp();
	}

	@Override
	public ServicioAplicacionCompra createSABilletes() {
		return new ServicioAplicacionCompraImp();
	}

	@Override
	public ServicioAplicacionInstanciaDeVuelo createSAInstanciaDeVuelo() {
		return new ServicioAplicacionInstanciaDeVueloImp();
	}

	@Override
	public ServicioAplicacionVuelo createSAVuelo() {
		return new ServicioAplicacionVueloImp();
	}
}
