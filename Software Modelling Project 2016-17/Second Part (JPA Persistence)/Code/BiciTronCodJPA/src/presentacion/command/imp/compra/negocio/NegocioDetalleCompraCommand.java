package presentacion.command.imp.compra.negocio;

import negocio.compra.imp.TransferCompra;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleCompraCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferCompra id = FactoriaServicioAplicacion.getInstance().createSACompra().detalleCompra((int) datos);
		return new Contexto(ListaComandos.MOSTRARDETALLECOMPRA, id);
	}
}
