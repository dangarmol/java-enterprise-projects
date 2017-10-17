package Negocio.Aeropuerto;

import java.util.ArrayList;

import Negocio.Aeropuerto.imp.TransferAeropuerto;

public interface ServicioAplicacionAeropuerto {

	public int altaAeropuerto(TransferAeropuerto t);

	public int bajaAeropuerto(int id);

	public int modificarAeropuerto(TransferAeropuerto t);

	public ArrayList<TransferAeropuerto> listaAeropuerto();

	public TransferAeropuerto detalleAeropuerto(int id);
}