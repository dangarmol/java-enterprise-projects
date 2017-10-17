package Negocio.InstanciaDeVuelo.imp;

import java.util.ArrayList;

import Integracion.factory.FactoryDAO;
import Negocio.Compra.imp.TransferBilletes;
import Negocio.InstanciaDeVuelo.ServicioAplicacionInstanciaDeVuelo;

public class ServicioAplicacionInstanciaDeVueloImp implements ServicioAplicacionInstanciaDeVuelo {
	
	public int altaInstanciaDeVuelo(TransferInstanciaDeVuelo t) {
		TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(t.getId());
		if (transfer == null) {
			if(FactoryDAO.getInstance().createDAOAvion().searchId(t.getAvion()) == null || FactoryDAO.getInstance().createDAOVuelo().searchId(t.getVuelo()) == null)
			{
				return 1;
			}
			if (FactoryDAO.getInstance().createDAOInstanciaDeVuelo().search(t.getFecha(), t.getAvion(), t.getVuelo()) != null) {
				return 1;
			}
			if (FactoryDAO.getInstance().createDAOInstanciaDeVuelo().add(t)) {
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
				FactoryDAO.getInstance().createDAOInstanciaDeVuelo().update(transfer);
				return 0;
			}
		}
	}

	public int bajaInstanciaDeVuelo(int id) {
		TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(id);
		if (transfer != null) {
			int cont = 1;
			TransferBilletes transferAux = FactoryDAO.getInstance().createDAOBilletes().searchId(cont);
			while(transferAux != null) {
				if(transferAux.getInstanciaDeVuelo() == id) {
					return 1;
				}
				cont++;
				transferAux = FactoryDAO.getInstance().createDAOBilletes().searchId(cont);
			}
			if (transfer.getActivo()) {
				transfer.setActivo(false);
				FactoryDAO.getInstance().createDAOInstanciaDeVuelo().update(transfer);
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

	public int modificarInstanciaDeVuelo(TransferInstanciaDeVuelo t) {
		TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(t.getId());
		if (transfer == null) {
			return 1;
		}
		if (FactoryDAO.getInstance().createDAOInstanciaDeVuelo().search(t.getFecha(), t.getAvion(), t.getVuelo()) != null) {
			return 1;
		}
		else {
			if(!t.getFecha().equals("_FILL_"))
				transfer.setFecha(t.getFecha());
			if(t.getAvion() != -2)
				transfer.setAvion(t.getAvion());
			if(t.getVuelo() != -2)
				transfer.setVuelo(t.getVuelo());
			if(t.getPlazasLibres() != -2)
				transfer.setPlazasLibres(t.getPlazasLibres());
			FactoryDAO.getInstance().createDAOInstanciaDeVuelo().update(transfer);
			return 0;
		}
	}

	public ArrayList<TransferInstanciaDeVuelo> listaInstanciaDeVuelo() {
		ArrayList<TransferInstanciaDeVuelo> lista = new ArrayList<TransferInstanciaDeVuelo>();
		int id = 1;
		TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(id);
		
		while(transfer != null) {
			id++;
			lista.add(transfer);
			transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(id);
		}
		return lista;
	}

	public TransferInstanciaDeVuelo detalleInstanciaDeVuelo(int id) {
		TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(id);
		return transfer;
	}
}