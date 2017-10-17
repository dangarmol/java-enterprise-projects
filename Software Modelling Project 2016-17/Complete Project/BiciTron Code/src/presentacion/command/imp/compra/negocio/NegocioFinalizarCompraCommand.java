package presentacion.command.imp.compra.negocio;

import negocio.compra.imp.TransferCompra;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioFinalizarCompraCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferCompra resultado = FactoriaServicioAplicacion.getInstance().createSACompra().finalizarCompra((TransferCompra) datos);
		return new Contexto(ListaComandos.MOSTRARFINALIZARCOMPRA, resultado);
	}
}