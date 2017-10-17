package Negocio.Compra;

import java.util.ArrayList;

import Negocio.Compra.imp.TransferBilletes;
import Negocio.Compra.imp.TransferCompra;

public interface ServicioAplicacionCompra {

	public int cerrarCompra(TransferCompra t);

	public TransferBilletes detalleBillete(int id);

	public int devolucionBillete(int id);

	public ArrayList<TransferBilletes> listadoBillete();

	public int modificarBillete(TransferBilletes t);
}