package negocio.bicicleta;

import java.util.ArrayList;

import presentacion.controlador.PareadoQuery;
import negocio.bicicleta.imp.TransferBicicleta;

public interface ServicioAplicacionBicicleta 
{
	public int altaBicicleta(TransferBicicleta t);
	public int bajaBicicleta(int id);
	public int modificarBicicleta(TransferBicicleta t);
	public TransferBicicleta detalleBicicleta(int id);
	public ArrayList<TransferBicicleta> listaBicicleta();
	public int numeroBicicletas(PareadoQuery pQuery);
}