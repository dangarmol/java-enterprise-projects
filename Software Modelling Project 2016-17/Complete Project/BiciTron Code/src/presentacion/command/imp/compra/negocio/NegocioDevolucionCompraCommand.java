package presentacion.command.imp.compra.negocio;

import negocio.compra.imp.TransferLineaCompra;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDevolucionCompraCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSACompra().devolverArticulo((TransferLineaCompra) datos);
		return new Contexto(ListaComandos.MOSTRARDEVOLUCIONARTICULOCOMPRA, id);
	}
}
