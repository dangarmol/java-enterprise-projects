package integracion.bicicleta;

import java.util.ArrayList;
import negocio.bicicleta.imp.TransferBicicleta;

public interface DaoBicicleta 
{
	public int add(TransferBicicleta t);
	public int update(TransferBicicleta t);
	public TransferBicicleta search(TransferBicicleta t);
	public TransferBicicleta searchId(int id);
	public ArrayList<TransferBicicleta> list();
}