package Negocio.Compra.imp;

import java.util.ArrayList;

import Integracion.factory.FactoryDAO;
import Negocio.Compra.ServicioAplicacionCompra;
import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;

public class ServicioAplicacionCompraImp implements ServicioAplicacionCompra {

	public int cerrarCompra(TransferCompra t) {
		int numBilletes = t.getBilletes().size();
		ArrayList<TransferBilletes> eliminar = new ArrayList<TransferBilletes> ();
		int exitos = 0;
		for (TransferBilletes p: t.getBilletes()) {
			TransferInstanciaDeVuelo transfer = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(p.getInstanciaDeVuelo());
			if (transfer == null || FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(p.getInstanciaDeVuelo()).getPlazasLibres() < 1) {
				eliminar.add(p);
				
			} else {
				FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(p.getInstanciaDeVuelo()).setPlazasLibres((FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(p.getInstanciaDeVuelo()).getPlazasLibres()) - 1);
				transfer.setPlazasLibres(transfer.getPlazasLibres() - 1);
				FactoryDAO.getInstance().createDAOInstanciaDeVuelo().update(transfer);
				exitos++;
			}
		}
		for (TransferBilletes p: eliminar) {
			t.removeBilleteId(p.getNumBillete());
		}
		if (FactoryDAO.getInstance().createDAOBilletes().add(t)) {
			if (exitos == numBilletes) {
				return 0;
			}
			else if (exitos == 0) {
				return 2;
			}
			else {
				return 1;
			}
		}
		return 2;
	}

	public TransferBilletes detalleBillete(int id) {
		TransferBilletes transfer = FactoryDAO.getInstance().createDAOBilletes().searchId(id);
		if (transfer == null) {
			return null;
		}
		else {
			return transfer;
		}
	}

	public int devolucionBillete(int id) {
		TransferBilletes transfer = FactoryDAO.getInstance().createDAOBilletes().searchId(id);
		if (transfer != null) {
			if (transfer.getActivo()) {
				transfer.setActivo(false);
				if (FactoryDAO.getInstance().createDAOBilletes().update(transfer)) {
					TransferInstanciaDeVuelo ti = FactoryDAO.getInstance().createDAOInstanciaDeVuelo().searchId(transfer.getInstanciaDeVuelo());
					ti.setPlazasLibres(ti.getPlazasLibres()+ 1);
					FactoryDAO.getInstance().createDAOInstanciaDeVuelo().update(ti);
					return 0;
				}
				return 1;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}

	public ArrayList<TransferBilletes> listadoBillete() {
		ArrayList<TransferBilletes> lista = new ArrayList<TransferBilletes>();
		int id = 1;
		TransferBilletes transfer = FactoryDAO.getInstance().createDAOBilletes().searchId(id);
		
		while(transfer != null) {
			id++;
			lista.add(transfer);
			transfer = FactoryDAO.getInstance().createDAOBilletes().searchId(id);
		}
		return lista;
	}

	public int modificarBillete(TransferBilletes t) {
		TransferBilletes transfer = FactoryDAO.getInstance().createDAOBilletes().searchId(t.getId());
		if (transfer == null) {
			return 1;
		}
		else {
			if(!t.getDni().equals("_FILL_"))
				transfer.setDni(t.getDni());
			if(t.getInstanciaDeVuelo() != -2)
				transfer.setInstanciaDeVuelo(t.getInstanciaDeVuelo());
			if(!t.getNombre().equals("_FILL_"))
				transfer.setNombre(t.getNombre());
			FactoryDAO.getInstance().createDAOBilletes().update(transfer);
			return 0;
		}
	}
}