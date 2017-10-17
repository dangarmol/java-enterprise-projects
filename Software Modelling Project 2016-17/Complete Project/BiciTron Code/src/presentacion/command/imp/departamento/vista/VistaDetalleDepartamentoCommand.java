package presentacion.command.imp.departamento.vista;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class VistaDetalleDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		return new Contexto(ListaComandos.VENTANADETALLEDEPARTAMENTO, datos);
	}
}
