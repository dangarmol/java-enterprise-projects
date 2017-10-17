package presentacion.command.imp.empleado.vista;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class VistaDetalleEmpleadoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		return new Contexto(ListaComandos.VENTANADETALLEEMPLEADO, datos);
	}
}
