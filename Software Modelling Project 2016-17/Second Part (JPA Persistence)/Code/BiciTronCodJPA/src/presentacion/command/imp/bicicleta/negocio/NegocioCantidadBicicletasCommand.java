package presentacion.command.imp.bicicleta.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.PareadoQuery;

public class NegocioCantidadBicicletasCommand implements Command 
{
	@Override
	public Contexto execute(Object datos)
	{
		int correcto = FactoriaServicioAplicacion.getInstance().createSABicicleta().numeroBicicletas((PareadoQuery) datos);
		return new Contexto(ListaComandos.MOSTRARCANTIDADBICICLETASQUERY, correcto);
	}
}
