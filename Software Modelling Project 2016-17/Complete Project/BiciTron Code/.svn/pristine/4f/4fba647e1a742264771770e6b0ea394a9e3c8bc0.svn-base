package presentacion.command.imp.empleado.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioBajaEmpleadoCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		int id = FactoriaServicioAplicacion.getInstance().createSAEmpleado().bajaEmpleado((int) datos);		
		return new Contexto(ListaComandos.MOSTRARBAJAEMPLEADO, id);
	}
}
