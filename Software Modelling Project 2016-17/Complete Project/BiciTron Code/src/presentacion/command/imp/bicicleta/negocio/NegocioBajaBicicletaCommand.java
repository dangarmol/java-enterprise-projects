package presentacion.command.imp.bicicleta.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioBajaBicicletaCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		int correcto = FactoriaServicioAplicacion.getInstance().createSABicicleta().bajaBicicleta((int) datos);
		return new Contexto(ListaComandos.MOSTRARBAJABICICLETA, correcto);
	}
}
