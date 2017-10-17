package presentacion.command.imp.tienda.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferTienda t = FactoriaServicioAplicacion.getInstance().createSATienda().detalleTienda((int) datos);
		return new Contexto(ListaComandos.MOSTRARDETALLETIENDA, t);
	}
}