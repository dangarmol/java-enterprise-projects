package Integracion.InstanciaDeVuelo;

import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;

public interface DaoInstanciaDeVuelo {
	
	public boolean add(TransferInstanciaDeVuelo t);

	public TransferInstanciaDeVuelo search(String fecha, int avion, int vuelo);

	public TransferInstanciaDeVuelo searchId(int id);

	public boolean update(TransferInstanciaDeVuelo t);
}