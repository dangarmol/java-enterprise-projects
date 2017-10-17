package presentacion.command.imp.empleado.negocio;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioAltaEmpleadoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSAEmpleado().altaEmpleado((TransferEmpleado) datos);		
		return new Contexto(ListaComandos.MOSTRARALTAEMPLEADO, id);
	}
}
