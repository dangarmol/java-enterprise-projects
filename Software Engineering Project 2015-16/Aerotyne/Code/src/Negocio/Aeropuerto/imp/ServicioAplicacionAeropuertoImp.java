package Negocio.Aeropuerto.imp;

import java.util.ArrayList;

import Integracion.factory.FactoryDAO;
import Negocio.Aeropuerto.ServicioAplicacionAeropuerto;
import Negocio.Vuelo.imp.TransferVuelo;

public class ServicioAplicacionAeropuertoImp implements ServicioAplicacionAeropuerto {

	public int altaAeropuerto(TransferAeropuerto t){
		TransferAeropuerto transfer = FactoryDAO.getInstance().createDAOAeropuerto().search(t.getNombre());
		if (transfer == null) {
			if (FactoryDAO.getInstance().createDAOAeropuerto().add(t)) {
					return 0;
			}
			else {
				return 1;
			}
		}
		else {
			if (transfer.getActivo()) {
				return 1;
			}
			else {
				transfer.setActivo(true);
				FactoryDAO.getInstance().createDAOAeropuerto().update(transfer);
				return 0;
			}
		}
	}

	public int bajaAeropuerto(int id) {
		TransferAeropuerto transfer = FactoryDAO.getInstance().createDAOAeropuerto().searchId(id);
		if (transfer != null) {
			int cont = 1;
			TransferVuelo transferVueloAux = FactoryDAO.getInstance().createDAOVuelo().searchId(cont);
			while(transferVueloAux != null) {
				if(transferVueloAux.getOrigen() == id || transferVueloAux.getDestino() == id) {
					return 1;
				}
				cont++;
				transferVueloAux = FactoryDAO.getInstance().createDAOVuelo().searchId(cont);
			}
			if (transfer.getActivo()) {
				transfer.setActivo(false);
				FactoryDAO.getInstance().createDAOAeropuerto().update(transfer);
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}

	public int modificarAeropuerto(TransferAeropuerto t) {
		TransferAeropuerto transfer = FactoryDAO.getInstance().createDAOAeropuerto().searchId(t.getId());
		if (t instanceof TransferAeropuertoSeguro && transfer instanceof TransferAeropuertoNoSeguro)
		{
			return 1;
		}
		if (t instanceof TransferAeropuertoNoSeguro && transfer instanceof TransferAeropuertoSeguro)
		{
			return 1;
		}
		if (transfer == null) {
			return 1;
		}
		if (FactoryDAO.getInstance().createDAOAeropuerto().search(t.getNombre()) != null) {
			return 1;
		}
		else {
			if(!t.getNombre().equals("_FILL_"))
				transfer.setNombre(t.getNombre());
			if(!t.getPais().equals("_FILL_"))
				transfer.setPais(t.getPais());
			if(!t.getCiudad().equals("_FILL_"))
				transfer.setCiudad(t.getCiudad());
			if (t instanceof TransferAeropuertoSeguro) {
				if(((TransferAeropuertoSeguro) t).getGradoSeguridad() != -2)
					((TransferAeropuertoSeguro) transfer).setGradoSeguridad(((TransferAeropuertoSeguro) t).getGradoSeguridad());
			}
			if (t instanceof TransferAeropuertoNoSeguro) {
				if(!((TransferAeropuertoNoSeguro) t).getDescripcion().equals("_FILL_"))
					((TransferAeropuertoNoSeguro) transfer).setDescripcion(((TransferAeropuertoNoSeguro) t).getDescripcion());
			}
			FactoryDAO.getInstance().createDAOAeropuerto().update(transfer);
			return 0;
		}
	}

	public ArrayList<TransferAeropuerto> listaAeropuerto() {
		ArrayList<TransferAeropuerto> lista = new ArrayList<TransferAeropuerto>();
		int id = 1;
		TransferAeropuerto transfer = FactoryDAO.getInstance().createDAOAeropuerto().searchId(id);
		
		while(transfer != null) {
			id++;
			lista.add(transfer);
			transfer = FactoryDAO.getInstance().createDAOAeropuerto().searchId(id);
		}
		return lista;
	}

	public TransferAeropuerto detalleAeropuerto(int id) {
		TransferAeropuerto transfer = FactoryDAO.getInstance().createDAOAeropuerto().searchId(id);
		if (transfer == null) {
			return null;
		}
		else {
			return transfer;
		}
	}
}