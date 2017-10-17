package Negocio.Vuelo.imp;

import java.util.ArrayList;

import Integracion.factory.FactoryDAO;
import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;
import Negocio.Vuelo.ServicioAplicacionVuelo;

public class ServicioAplicacionVueloImp implements ServicioAplicacionVuelo {

	public int altaVuelo(TransferVuelo t){
		TransferVuelo transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(t.getId());
		if (transfer == null) {
			if(FactoryDAO.getInstance().createDAOAeropuerto().searchId(t.getOrigen()) == null || FactoryDAO.getInstance().createDAOAeropuerto().searchId(t.getDestino()) == null)
			{
				return 1;
			}
			if (FactoryDAO.getInstance().createDAOVuelo().search(t.getOrigen(), t.getDestino(), t.getDiaSemana(), t.getHora()) != null) {
				return 1;
			}
			if (FactoryDAO.getInstance().createDAOVuelo().add(t)) {
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
				FactoryDAO.getInstance().createDAOVuelo().update(transfer);
				return 0;
			}
		}
	}

	public int bajaVuelo(int id) {
		TransferVuelo transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(id);
		if (transfer != null) {
			int cont = 1;
			TransferInstanciaDeVuelo transferInstanciaAux = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(cont);
			while(transferInstanciaAux != null) {
				if(transferInstanciaAux.getVuelo() == id) {
					return 1;
				}
				cont++;
				transferInstanciaAux = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(cont);
			}
			if (transfer.getActivo()) {
				transfer.setActivo(false);
				FactoryDAO.getInstance().createDAOVuelo().update(transfer);
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

	public int modificarVuelo(TransferVuelo t) {
		TransferVuelo transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(t.getId());
		if (transfer == null) {
			return 1;
		}
		if (FactoryDAO.getInstance().createDAOVuelo().search(t.getOrigen(), t.getDestino(), t.getDiaSemana(), t.getHora()) != null) {
			return 1;
		}
		else {
			if(!t.getHora().equals("_FILL_"))
				transfer.setHora(t.getHora());
			if(!t.getDiaSemana().equals("_FILL_"))
				transfer.setDiaSemana(t.getDiaSemana());
			if(t.getOrigen() != -2)
				transfer.setOrigen(t.getOrigen());
			if(t.getDestino() != -2)
				transfer.setDestino(t.getDestino());
			FactoryDAO.getInstance().createDAOVuelo().update(transfer);
			return 0;
		}
	}

	public ArrayList<TransferVuelo> listaVuelo() {
		ArrayList<TransferVuelo> lista = new ArrayList<TransferVuelo>();
		int id = 1;
		TransferVuelo transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(id);
		
		while(transfer != null) {
			id++;
			lista.add(transfer);
			transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(id);
		}
		return lista;
	}

	public TransferVuelo detalleVuelo(int id) {
		TransferVuelo transfer = FactoryDAO.getInstance().createDAOVuelo().searchId(id);
		
		return transfer;
	}
}