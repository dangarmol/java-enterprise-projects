package presentacion.command.imp.bicicleta.negocio;

import negocio.bicicleta.imp.TransferBicicleta;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleBicicletaCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferBicicleta t = FactoriaServicioAplicacion.getInstance().createSABicicleta().detalleBicicleta((int) datos);
		return new Contexto(ListaComandos.MOSTRARDETALLEBICICLETA, t);
	}
}
