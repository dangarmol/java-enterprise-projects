package Negocio.Avion.imp;

import java.util.ArrayList;

import Integracion.factory.FactoryDAO;
import Negocio.Avion.ServicioAplicacionAvion;
import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;

public class ServicioAplicacionAvionImp implements ServicioAplicacionAvion {

	public int altaAvion(TransferAvion t) {
		TransferAvion transfer = FactoryDAO.getInstance().createDAOAvion().search(t.getMatricula());
		if (transfer == null) {
			if (FactoryDAO.getInstance().createDAOAvion().add(t)) {
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
				FactoryDAO.getInstance().createDAOAvion().update(transfer);
				return 0;
			}
		}
	}

	public int bajaAvion(int id) {
		TransferAvion transfer = FactoryDAO.getInstance().createDAOAvion().searchId(id);
		if (transfer != null) {
			int cont = 1;
			TransferInstanciaDeVuelo transferInstanciaAux = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(cont);
			while(transferInstanciaAux != null) {
				if(transferInstanciaAux.getAvion() == id) {
					return 1;
				}
				cont++;
				transferInstanciaAux = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(cont);
			}
			if (transfer.getActivo()) {
				transfer.setActivo(false);
				FactoryDAO.getInstance().createDAOAvion().update(transfer);
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

	public int modificarAvion(TransferAvion t) {
		TransferAvion transfer = FactoryDAO.getInstance().createDAOAvion().searchId(t.getId());
		if (transfer == null) {
			return 1;
		}
		if (FactoryDAO.getInstance().createDAOAvion().search(t.getMatricula()) != null) {
			return 1;
		}
		else {
			if(!t.getMatricula().equals("_FILL_"))
				transfer.setMatricula(t.getMatricula());
			if(!t.getModelo().equals("_FILL_"))
				transfer.setModelo(t.getModelo());
			if(t.getNumPlazas() != -2)
				transfer.setNumPlazas(t.getNumPlazas());
			FactoryDAO.getInstance().createDAOAvion().update(transfer);
			return 0;
		}
	}

	public ArrayList<TransferAvion> listaAvion() {
		ArrayList<TransferAvion> lista = new ArrayList<TransferAvion>();
		int id = 1;
		TransferAvion transfer = FactoryDAO.getInstance().createDAOAvion().searchId(id);
		
		while(transfer != null) {
			id++;
			lista.add(transfer);
			transfer = FactoryDAO.getInstance().createDAOAvion().searchId(id);
		}
		return lista;
	}

	public TransferAvion detalleAvion(int id) {
		TransferAvion transfer = FactoryDAO.getInstance().createDAOAvion().searchId(id);
		
		if (transfer == null) {
			return null;
		}
		else {
			return transfer;
		}
	}
}