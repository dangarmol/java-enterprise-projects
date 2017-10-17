package presentacion.command.imp.tienda.negocio;

import java.util.ArrayList;

import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferTienda;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		ArrayList<TransferTienda> lista = FactoriaServicioAplicacion.getInstance().createSATienda().listaTienda();		
		return new Contexto(ListaComandos.MOSTRARLISTATIENDA, lista);
	}
}
