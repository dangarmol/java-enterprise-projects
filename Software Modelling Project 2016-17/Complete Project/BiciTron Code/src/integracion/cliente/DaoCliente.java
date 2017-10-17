package integracion.cliente;

import java.util.ArrayList;
import negocio.cliente.imp.TransferCliente;

public interface DaoCliente 
{
	public int add(TransferCliente t);
	public int update(TransferCliente t);
	public TransferCliente search(TransferCliente t);
	public TransferCliente searchId(int id);
	public ArrayList<TransferCliente> list();
}