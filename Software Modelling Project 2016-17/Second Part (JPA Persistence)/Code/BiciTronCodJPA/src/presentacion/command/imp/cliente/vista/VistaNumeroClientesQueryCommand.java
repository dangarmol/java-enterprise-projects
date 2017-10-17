package presentacion.command.imp.cliente.vista;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class VistaNumeroClientesQueryCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		return new Contexto(ListaComandos.VENTANANUMEROCLIENTESQUERY, datos);
	}
}