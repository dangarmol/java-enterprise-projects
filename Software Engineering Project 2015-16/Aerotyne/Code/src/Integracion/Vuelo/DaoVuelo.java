package Integracion.Vuelo;

import Negocio.Vuelo.imp.TransferVuelo;

public interface DaoVuelo {

	public boolean add(TransferVuelo t);

	public TransferVuelo search(int origen, int destino, String diaSemana, String hora);

	public TransferVuelo searchId(int id);

	public boolean update(TransferVuelo t);
}