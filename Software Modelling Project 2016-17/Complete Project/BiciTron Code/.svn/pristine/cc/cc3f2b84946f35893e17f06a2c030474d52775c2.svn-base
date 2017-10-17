package presentacion.command.imp.bicicleta.negocio;

import negocio.bicicleta.imp.TransferBicicleta;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioModificarBicicletaCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		int id = FactoriaServicioAplicacion.getInstance().createSABicicleta().modificarBicicleta((TransferBicicleta) datos);
		return new Contexto (ListaComandos.MOSTRARMODIFICARBICICLETA, id);
	}
}
