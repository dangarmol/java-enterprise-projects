package presentacion.command.imp.empleado.negocio;

import negocio.empleado.imp.TransferEmpleado;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleEmpleadoCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		TransferEmpleado t = FactoriaServicioAplicacion.getInstance().createSAEmpleado().detalleEmpleado((int) datos);		
		return new Contexto(ListaComandos.MOSTRARDETALLEEMPLEADO, t);
	}
}
