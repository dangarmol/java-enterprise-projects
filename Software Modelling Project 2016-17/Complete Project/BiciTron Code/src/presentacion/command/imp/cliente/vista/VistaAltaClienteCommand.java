package presentacion.command.imp.cliente.vista;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class VistaAltaClienteCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		return new Contexto(ListaComandos.VENTANAALTACLIENTE, datos);
	}
}
