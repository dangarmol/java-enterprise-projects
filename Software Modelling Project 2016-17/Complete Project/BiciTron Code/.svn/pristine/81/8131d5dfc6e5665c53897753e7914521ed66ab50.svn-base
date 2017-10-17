package presentacion.command.imp.tienda.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioModificarTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().modificarTienda((TransferTienda)datos);		
		return new Contexto(ListaComandos.MOSTRARMODIFICARTIENDA, id);
	}
}
