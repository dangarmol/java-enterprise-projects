package Integracion.Compra;

import Negocio.Compra.imp.TransferBilletes;
import Negocio.Compra.imp.TransferCompra;

public interface DaoCompra {
	public boolean add(TransferCompra t);
	
	public boolean addBillete(TransferBilletes p);
	
	public TransferBilletes searchId(int id);
	
	public boolean update(TransferBilletes t);
}