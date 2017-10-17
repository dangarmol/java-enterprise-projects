package presentacion.command.imp.tienda.vista;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class VistaAsignarDepartamentoTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		return new Contexto(ListaComandos.VENTANAASIGNARDEPARTAMENTOTIENDA, datos);
	}
}
