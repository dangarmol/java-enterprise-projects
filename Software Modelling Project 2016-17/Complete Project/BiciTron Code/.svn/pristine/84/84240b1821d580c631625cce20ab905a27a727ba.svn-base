package presentacion.command.imp.tienda.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetallePresupuestoTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferPresupuesto t = FactoriaServicioAplicacion.getInstance().createSATienda().detallePresupuesto((TransferPresupuesto)datos);
		return new Contexto(ListaComandos.MOSTRARDETALLEPRESUPUESTOTIENDA, t);
	}
}
