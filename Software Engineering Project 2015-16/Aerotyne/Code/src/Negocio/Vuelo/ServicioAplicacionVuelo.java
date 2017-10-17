package Negocio.Vuelo;

import java.util.ArrayList;

import Negocio.Vuelo.imp.TransferVuelo;

public interface ServicioAplicacionVuelo {

	public int altaVuelo(TransferVuelo t);

	public int bajaVuelo(int id);

	public int modificarVuelo(TransferVuelo t);

	public ArrayList<TransferVuelo> listaVuelo();

	public TransferVuelo detalleVuelo(int id);
}