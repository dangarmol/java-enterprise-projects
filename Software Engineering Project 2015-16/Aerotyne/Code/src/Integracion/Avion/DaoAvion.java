package Integracion.Avion;

import Negocio.Avion.imp.TransferAvion;

public interface DaoAvion {
	public boolean add(TransferAvion t);
	
	public TransferAvion search(String matricula);
	
	public TransferAvion searchId(int id);

	public boolean update(TransferAvion t);
}