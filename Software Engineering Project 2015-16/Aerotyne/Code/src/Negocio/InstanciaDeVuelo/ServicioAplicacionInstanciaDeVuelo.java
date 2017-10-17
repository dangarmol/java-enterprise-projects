package Negocio.InstanciaDeVuelo;

import java.util.ArrayList;

import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;

public interface ServicioAplicacionInstanciaDeVuelo {

	public int altaInstanciaDeVuelo(TransferInstanciaDeVuelo t);

	public int bajaInstanciaDeVuelo(int id);

	public int modificarInstanciaDeVuelo(TransferInstanciaDeVuelo t);

	public ArrayList<TransferInstanciaDeVuelo> listaInstanciaDeVuelo();

	public TransferInstanciaDeVuelo detalleInstanciaDeVuelo(int id);
}