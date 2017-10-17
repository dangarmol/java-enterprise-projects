package integracion.compra;

import java.util.ArrayList;
import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaCompra;

public interface DaoCompra 
{
	public int add(TransferCompra tCompra);
	public TransferCompra searchId(int id);
	public TransferLineaCompra searchLineaCompra(TransferLineaCompra tLineaCompra);
	public int devolucionArticulo(TransferCompra tCompra, TransferLineaCompra tLineaCompra);
	public ArrayList<TransferCompra> list();
}