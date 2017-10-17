package presentacion.command.imp.empleado.negocio;

import java.util.ArrayList;
import negocio.empleado.imp.TransferEmpleado;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaEmpleadoCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		ArrayList<TransferEmpleado> lista = FactoriaServicioAplicacion.getInstance().createSAEmpleado().listaEmpleado();		
		return new Contexto(ListaComandos.MOSTRARLISTAEMPLEADO, lista);
	}
}
