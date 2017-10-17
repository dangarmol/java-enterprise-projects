package presentacion.command.imp.tienda.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioBajaTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().bajaTienda((int)datos);		
		return new Contexto(ListaComandos.MOSTRARBAJATIENDA, id);
	}
}
