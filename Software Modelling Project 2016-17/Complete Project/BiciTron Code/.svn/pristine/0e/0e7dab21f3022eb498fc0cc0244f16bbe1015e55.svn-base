package presentacion.command.imp.tienda.negocio;

import java.util.ArrayList;
import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaPresupuestoTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		ArrayList<TransferPresupuesto> lista = FactoriaServicioAplicacion.getInstance().createSATienda().listaPresupuesto();		
		return new Contexto(ListaComandos.MOSTRARLISTAPRESUPUESTOTIENDA, lista);
	}
}
