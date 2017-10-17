package Integracion.Aeropuerto;

import Negocio.Aeropuerto.imp.TransferAeropuerto;

public interface DaoAeropuerto {
	public boolean add(TransferAeropuerto t);
	
	public TransferAeropuerto search(String nombre);

	public TransferAeropuerto searchId(int id);

	public boolean update(TransferAeropuerto t);
}