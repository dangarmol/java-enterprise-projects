package Negocio.Avion;

import java.util.ArrayList;

import Negocio.Avion.imp.TransferAvion;

public interface ServicioAplicacionAvion {

	public int altaAvion(TransferAvion t);

	public int bajaAvion(int id);

	public int modificarAvion(TransferAvion t);

	public ArrayList<TransferAvion> listaAvion();

	public TransferAvion detalleAvion(int id);
}